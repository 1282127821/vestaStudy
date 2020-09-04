package com.xy.懒加载;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.objenesis.Objenesis;

import java.io.IOException;

public class bootstrap {
    public static void main(String[] args) throws IOException {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.xy.懒加载");
        ALazyDemo aLazyDemo = ctx.getBean(ALazyDemo.class);
        BLazyDemo bean = ctx.getBean(BLazyDemo.class);
        aLazyDemo.get();

    }
}
