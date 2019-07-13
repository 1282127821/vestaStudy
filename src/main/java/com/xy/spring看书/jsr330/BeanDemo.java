package com.xy.spring看书.jsr330;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.test.context.jdbc.Sql;

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
        short a=1;
        short b=1;
        int i = a * b;//int类型
        byte c=1;
        int i1 = a + c;//int类型

        float d=1.1f;
        float e=1.1f;
        float v1 = d + e;//float类型
        double v = d + 1.2;//double类型

        double v2 = 1.5 + 2.0;//double类型

        int i2 = 1 + 2;//int类型

        System.out.println(Integer.MAX_VALUE);//2147483647
        int one=100;
        long l1=Integer.MAX_VALUE *one;
        System.out.println(l1);//-100越界了，导致正数*正数变成负数

        long l2=Integer.MAX_VALUE *(long)one;
        System.out.println(l2);//214748364700正常结果


    }
}
