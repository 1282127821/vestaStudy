package com.xy.懒加载;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * @fileName:ALazyDemo
 * @author:xy
 * @date:2020/9/3
 * @description:
 */
@Component
public class ALazyDemo implements Serializable {

    public int anInt;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Autowired
//    @Lazy
    private BLazyDemo bLazyDemo;
    @Autowired
    private CLazyDemo cLazyDemo;

    private ALazyDemo() {
        System.out.println("ALazyDemo加载" + this);
    }

    @PostConstruct
    public void get() {
        System.out.println(bLazyDemo.anInt);
    }
}
