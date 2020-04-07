package com.xy.hotPlugin;

import com.alibaba.fastjson.JSON;
import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @fileName:DefaultSpringPluginFactory
 * @author:xy
 * @date:2019/7/13
 * @description:
 */
@Component
public class DefaultSpringPluginFactory implements ApplicationContextAware {
    //本地库位置
    private static final String BASE_DIR = "G:\\work\\data\\demo\\\\local\\";
    /**
     * 这个表示当前本地库
     */
    private Map<Integer, PluginConfig> configs = new HashMap<>();
    /**
     * 这个表示当前jvm正在使用的jar
     */
    private Map<String, Advice> adviceCache = new HashMap<>();
    private ApplicationContext applicationContext;

    public void insatallPlugin(PluginConfig plugin, boolean active) {
        //如果当前jvm已经安装了，那么就直接提示
        if (configs.containsKey(plugin.getId())) {
            throw new RuntimeException(String.format("已经存在指定插件id=%s0", plugin.getId()));
        }
        //填充到插件库
        configs.put(plugin.getId(), plugin);
        //下载远程插件
        try {
            buildAdvice(plugin);
        } catch (Exception e) {
            configs.remove(plugin.getId());
            throw new RuntimeException(String.format("插件构建失败id=%s0", plugin.getId()));
        }
        //下载完毕后就是持久化到本地库
        try {
            storeConfigs();
        } catch (Exception e) {
            configs.remove(plugin.getId());
            throw new RuntimeException(String.format("插件安装失败id=%s0", plugin.getId()));
        }
        if (active) {
            //TODO 传入的是true则在安装插件时候顺便激活它
        }
    }

    /** 加载本地*/
    @PostConstruct
    public void loaderLocals() throws Exception {
        /** 读取本地插件到项目中*/
        Map<Integer, PluginConfig> localConfigs = readLocalConfigs();
        if (localConfigs==null){
            return;
        }
        configs.putAll(localConfigs);
        for (PluginConfig config : configs.values()) {
            //如果配置文件表示它可激活才会去激活它
            if (config.isActive()){
                activePlugins(config.getId());
            }
        }
    }

    public void activePlugins(int pluginId) {
        if (!configs.containsKey(pluginId)){
            throw new RuntimeException(String.format("指定插件不存在id=%s0", pluginId));
        }
        PluginConfig config = configs.get(pluginId);
        //下面就是利用spring动态添加aop通知
        for (String name : applicationContext.getBeanDefinitionNames()) {
            Object bean = applicationContext.getBean(name);
            if (bean == this){
                continue;
            }
            if (!(bean instanceof Advised)){
                continue;
            }
            if (findAdvice(config.getClassName(),(Advised)bean!=null)){
                continue;
            }
            Advice advice=null;
            try {
                //获取通知对象
                advice=buildAdvice(config);
                //添加通知
                ((Advised)bean).addAdvice(advice);

            } catch (Exception e) {
                throw new RuntimeException("安装失败",e);
            }
        }
        try {
            //修改配置文件为已激活
            config.setActive(true);
            storeConfigs();
        } catch (IOException e) {
            //TODO 需要回滚已添加的切面
            throw new RuntimeException("激活失败",e);
        }
    }

    private boolean findAdvice(String className, boolean b) {
        //说明已激活?
        if (adviceCache.containsKey(className)){
            return true;
        }
        return false;
    }

    private Map<Integer, PluginConfig> readLocalConfigs() throws Exception {
        File configFile=new File(BASE_DIR+"PluginConfigs.json");
        if (!configFile.exists()){
            return null;
        }
        FileInputStream in = new FileInputStream(configFile);
        Map<Integer, PluginConfig> result = new HashMap<>();
        //怪不得用这个ByteArrayOutputStream,他有一个直接将流转换为字符串
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        //当读取大小不知道的时候就使用in.available()
        byte[] bytes=new byte[in.available()];
        in.read(bytes);
        out.write(bytes);
        PluginStore store = JSON.parseObject(out.toString("UTF-8"), PluginStore.class);
        for (PluginConfig config : store.getPlugin()) {
            result.put(config.getId(), config);
        }
        return result;

    }

    private void storeConfigs() throws IOException {
        File configFile = new File(BASE_DIR + "PluginConfigs.json");
        //不存在则创建，存在直接追加
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            configFile.createNewFile();
        }
        PluginStore sotre = new PluginStore();
        sotre.setLastModify(new Date());
        sotre.setPlugin(configs.values());
        String jsonString = JSON.toJSONString(sotre, true);
        FileOutputStream out = new FileOutputStream(configFile);
        out.write(jsonString.getBytes("UTF-8"));
        out.flush();
        out.close();
    }

    private Advice buildAdvice(PluginConfig plugin) throws Exception {
        if (adviceCache.containsKey(plugin.getClassName())) {
            return adviceCache.get(plugin.getClassName());
        }
        //先判断本地是否有这个jar
        File jarFile = new File(getLocalJarFile(plugin));
        //从远处下载plugin 文件到本地(我这里模拟从一个文件夹到另外一个文件夹)
        if (!jarFile.exists()) {
            URL url = new URL(plugin.getJarRemoteUrl());
            InputStream stream = url.openStream();
            jarFile.getParentFile().mkdirs();
            try {
                Files.copy(stream, jarFile.toPath());
            } catch (IOException e) {
                jarFile.deleteOnExit();
                throw new RuntimeException("下载异常");
            }
            stream.close();
        }
        //远程下载完毕后,从本地将jar加载到虚拟机中(也就是内存中)
        URLClassLoader loader = (URLClassLoader) this.getClass().getClassLoader();
        URL targetUrl = jarFile.toURI().toURL();
        boolean isLoader = false;
        for (URL url : loader.getURLs()) {
            if (url.equals(targetUrl)) {
                isLoader = true;
                break;
            }
        }
        //也就是没有被当前类加载器加载到虚拟机(不排除其他类加载器)
        //由于addURL这个方法是保护方法所以通过反射操作他
        if (!isLoader) {
            Method add = URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{URL.class});
            add.setAccessible(true);
            add.invoke(loader, targetUrl);
        }
        //加载到虚拟机后进行实例化操作
        Class<?> adviceClass = loader.loadClass(plugin.getClassName());
        if (!Advice.class.isAssignableFrom(adviceClass)) {
            throw new RuntimeException(String.format("plugin 配置错误%s非%s的实现类", plugin.getClassName(), Advice.class.toString()));
        }
        adviceCache.put(adviceClass.getName(), (Advice) adviceClass.newInstance());
        return adviceCache.get(adviceClass.getName());
    }

    //这个到时候读取本地json看能否找到这个插件
    public static String getLocalJarFile(PluginConfig plugin) {
        //TODO 这里到时候无非就是从远程url分析出jar名称
        String[] split = plugin.getJarRemoteUrl().split("/");
//        String jarNmae = plugin.getJarRemoteUrl().substring(split[split.length-1], 1);
        String jarNmae = split[split.length-1];
        return BASE_DIR + jarNmae;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
