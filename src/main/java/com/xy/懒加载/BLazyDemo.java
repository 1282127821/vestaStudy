package com.xy.懒加载;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @fileName:BLazyDemo
 * @author:xy
 * @date:2020/9/3
 * @description:
 */
@Component
//@Lazy
public class BLazyDemo {
    public int anInt = 0;
    @Autowired
    private ALazyDemo cLazyDemo;


    public BLazyDemo() {
        anInt = 100;
        System.out.println("BLazyDemo加载" + this);
        System.out.println(this.anInt);
    }
}
