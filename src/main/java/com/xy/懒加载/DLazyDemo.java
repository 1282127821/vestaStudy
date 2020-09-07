package com.xy.懒加载;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @fileName:DLazyDemo
 * @author:xy
 * @date:2020/9/3
 * @description:
 */
@Component
public class DLazyDemo implements SmartInstantiationAwareBeanPostProcessor {
    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        System.err.println(bean);
//        ALazyDemo bean1 = (ALazyDemo) bean;
//        bean1.anInt=1000;
        return bean;
    }
}
