package com.xy.spring看书;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/**
 * @fileName:FactoryBeanDemo
 * @author:xy
 * @date:2019/6/8
 * @description:
 */
@Component
public class FactoryBeanDemo implements FactoryBean<MessageDigest>, InitializingBean {
    /**
     *FactoryBean一般用于动态生成bean,也就是bean的id是一样的，但是呢 具体是什么对象不确定根据具体配置
     * 生成不同对象，如我可能生成md5对象，也可能是SHA1
     * 和这个匹配的注解是@Bean
     * 然后内部原理是，扫描到这个类会被spring管理以后，就会判断他是否是FactoryBean子类是的话调用getObject
     * 然后将获得的对象放入spring容器，beanName是@Component修饰的类对应的名称
     *
     * 那么如何获取 FactoryBeanDemo这个对象呢？其实也可以获取的，只不过他放入spring容器的名称是如下
     * <&factoryBeanDemo,对象>  注意多了一个&
     */
    private String value="MD5";
    private MessageDigest messageDigest;
    @Override
    public MessageDigest getObject() throws Exception {
        return messageDigest;
    }

    @Override
    public Class<MessageDigest> getObjectType() {
        return MessageDigest.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //选择加密方式
        messageDigest = MessageDigest.getInstance(value);
    }
    //外部设置加密方式
    public void setValue(String value) {
        this.value = value;
    }
}
