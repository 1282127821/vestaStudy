package com.xy.懒加载;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @fileName:CLazyDemo
 * @author:xy
 * @date:2020/9/3
 * @description:
 */
@Component
@Lazy
public class CLazyDemo {
    public CLazyDemo() {
        System.out.println("CLazyDemo加载");
    }

    @Bean
    @Lazy
    public DLazyDemo getDLazyDemo() {
        System.out.println("DLazyDemo加载");
        return new DLazyDemo();
    }
}
