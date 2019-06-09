package com.xy.spring看书.jsr330;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @fileName:BeanDemo
 * @author:xy
 * @date:2019/6/9
 * @description:
 */
@Configuration
public class BeanDemo {
    @Bean
    public String string(){
        return new String("string");
    }
}
