package com.xy.spring看书;

import com.xy.spring看书.config.Profile1;
import com.xy.spring看书.config.Profile2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.io.IOException;

public class bootstrap3 {
    public static void main(String[] args) throws IOException {
        //----------------------------Profile
        /**
         * 注意这个东西要配合 jvm参数一起使用，值就是我们选择的开发模式。即@Profile("profile2")指定的名称
         *-Dspring.profiles.active="profile1"
         */
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(Profile1.class,Profile2.class);
        System.out.println(ctx.getBean("p1"));

        //---------------------Environment
        ConfigurableEnvironment env = ctx.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();



    }
}
