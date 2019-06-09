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
@Profile("profile1")
public class Profile1 {
    /**
     *我们知道profile一般都是用来选择选择不同环境的比如开发环境使用这套测试环境使用那套
     */
    @Bean
    public P1 p1(){
        return new P1();
    }
}

