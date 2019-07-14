package com.xy.hotPlugin;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @fileName:Test
 * @author:xy
 * @date:2019/7/14
 * @description:
 */
public class Test {
    private DefaultSpringPluginFactory factory=new DefaultSpringPluginFactory();
    @org.junit.jupiter.api.Test
    public void testGetLocalJarFile() throws MalformedURLException {
        PluginConfig pluginConfig=new PluginConfig();
        String file="file:D:/site/com.xy.aop.plugin-0.0.2-SINAPSHOT.jar";
        pluginConfig.setJarRemoteUrl(file);
        String localJarFile = DefaultSpringPluginFactory.getLocalJarFile(pluginConfig);
        System.out.println(localJarFile);

        //测试必须 file:D:/site/com.xy.aop.plugin-0.0.2-SINAPSHOT.jar 有file:表示协议
        URL url=new URL(pluginConfig.getJarRemoteUrl());
        System.out.println(url);
    }
    @org.junit.jupiter.api.Test
    public void testInstall() throws MalformedURLException {
        PluginConfig pluginConfig=new PluginConfig();
        pluginConfig.setActive(false);
        pluginConfig.setId(1);
        pluginConfig.setVersion("v1.0.0");
        pluginConfig.setJarRemoteUrl(
                "file:G:/work/data/demo/remote/springboot3-0.0.1-SNAPSHOT.jar"
        );
        pluginConfig.setClassName("com.xy.hotPlugin.PrintDateMethodBeforeAdvice");
        pluginConfig.setName("测试用例");
        factory.insatallPlugin(pluginConfig, false);

    }

    /** spring动态添加通知方式*/
    @org.junit.jupiter.api.Test
    public void testDynAddAdvice(){
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurationClass.class);
        UserService bean = ctx.getBean(UserService.class);
        Advised advised= (Advised) bean;
        PrintDateMethodBeforeAdvice printDateMethodBeforeAdvice=new PrintDateMethodBeforeAdvice();
        advised.addAdvice(printDateMethodBeforeAdvice);
        bean.hello();
        advised.removeAdvice(printDateMethodBeforeAdvice);
        bean.hello();
    }

    @org.junit.jupiter.api.Test
    public void testActive() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurationClass.class);
        DefaultSpringPluginFactory factory = ctx.getBean(DefaultSpringPluginFactory.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.hello();
        factory.activePlugins(1);
        userService.hello();
    }
    //销毁不不举例了，其实就是和激活对立面而已,从aop动态移除该通知，然后本地库是否激活状态变为false
}
