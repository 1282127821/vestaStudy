package com.xy.spring看书;

import com.xy.spring看书.config.Animal;
import com.xy.spring看书.event.MessageEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

public class bootstrap2 {
    public static void main(String[] args) throws IOException {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext("com.xy.spring看书.config");
//        System.out.println(ctx.getBean("name2"));
//        System.out.println(ctx.getBean(Animal.class));
        System.out.println(ctx.getBean("com.xy.spring看书.config.Animal"));

        //----------------------------Profile

    }
}
