package com.xy.懒加载;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @fileName:ALazyDemo
 * @author:xy
 * @date:2020/9/3
 * @description:
 */
@Component
public class ALazyDemo {
    @Autowired
    @Lazy
    private BLazyDemo bLazyDemo;

    public ALazyDemo() {
        System.out.println("ALazyDemo加载" + this);
    }

    @PostConstruct
    public void get() {
        System.out.println(bLazyDemo.anInt);
    }
}
