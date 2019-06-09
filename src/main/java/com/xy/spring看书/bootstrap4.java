package com.xy.spring看书;

import com.xy.spring看书.config.Profile1;
import com.xy.spring看书.config.Profile2;
import com.xy.spring看书.jsr330.MessageProvider;
import com.xy.spring看书.jsr330.MessageProviderImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.io.IOException;

public class bootstrap4 {
    public static void main(String[] args) throws IOException {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.xy.spring看书.jsr330");
        System.out.println(ctx.getBean("messageProvider", MessageProviderImpl.class).getMessage());


    }
}
