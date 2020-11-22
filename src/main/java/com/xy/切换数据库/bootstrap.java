package com.xy.切换数据库;

import com.xy.懒加载.ALazyDemo;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
@ComponentScan(value = "com.xy.切换数据库")
public class bootstrap implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(bootstrap.class, args);
        MysqlDemo mysqlDemo = applicationContext.getBean(MysqlDemo.class);
        System.out.println(mysqlDemo.getUsername());

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
