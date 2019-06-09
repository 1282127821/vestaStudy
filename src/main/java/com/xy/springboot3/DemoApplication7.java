package com.xy.springboot3;

import com.xy.springboot3.test.A;
import com.xy.springboot3.test.B;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@ComponentScan(value = "com.xy.springboot3.test")
public class DemoApplication7 implements  CommandLineRunner, ApplicationContextAware {
    @Autowired
    private B b;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication7.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(b+"---------------------------------------->");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.err.println(beanDefinitionName);
        }
    }
}
