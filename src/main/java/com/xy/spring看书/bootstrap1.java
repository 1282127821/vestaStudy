package com.xy.spring看书;

import com.xy.springboot3.test.B;
import com.xy.spring看书.event.MessageEvent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

public class bootstrap1 {
    public static void main(String[] args) throws IOException {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext("com.xy.spring看书");
        Object destoryDemo = ctx.getBean("destoryDemo");
        System.out.println(destoryDemo);
        ctx.registerShutdownHook();
//        ctx.destroy();

        //---------------FactoryBeanDemo
        Object messageDigest = ctx.getBean("factoryBeanDemo");
        System.out.println(messageDigest);
        Object factoryBeanDemo = ctx.getBean("&factoryBeanDemo");
        System.out.println(factoryBeanDemo);
        //-------------------------MessageListener
        ctx.publishEvent(new MessageEvent("你好source"));
        //----------------------------Rsource
        Resource resource = ctx.getResource("https://www.baidu.com/");
        System.out.println(resource.getURL().getContent());
        //java里面创建临时文件的方式
        File tempFile = File.createTempFile("test", ".txt");
        tempFile.deleteOnExit();
        System.out.println(tempFile.getPath());


    }
}
