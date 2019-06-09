package com.xy.spring看书.config;

import com.xy.spring看书.P1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @fileName:Profile1
 * @author:xy
 * @date:2019/6/8
 * @description:
 */
@Configuration
@Profile("profile2")
public class Profile2 {
    @Bean
    public P1 p1(){
        return new P1();
    }
}
