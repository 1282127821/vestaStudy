package com.xy.跨域;

import com.sun.nio.zipfs.ZipPath;
import jdk.nashorn.internal.codegen.Compiler;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@ComponentScan(value = "com.xy.跨域")
public class DemoApplication implements  CommandLineRunner, ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("<<<<<"+ZipPath.class.getClassLoader());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }
}
