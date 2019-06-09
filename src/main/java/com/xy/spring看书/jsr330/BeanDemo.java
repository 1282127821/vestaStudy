package com.xy.spring看书.jsr330;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
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

    @Test
    @DisplayName("依赖注入1")
    public void testInfo(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }
}
