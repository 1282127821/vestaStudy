package com.xy.spring看书.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @fileName:SpringTest
 * @author:xy
 * @date:2019/6/9
 * @description:
 */
@SpringJUnitConfig(classes = {SimpleTestConfig.class})
@DisplayName("test use")
@ActiveProfiles("test")//这个注解表示引用哪一个profile
public class SpringTest {
    @Test
    public void test(){
        
    }
}
