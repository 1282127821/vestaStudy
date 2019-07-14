package com.xy.aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @fileName:AopService
 * @author:xy
 * @date:2019/7/13
 * @description:
 */
@Component
public class AopServiceImpl  implements  AopService {
    @Log
    @Override
    public void testSetvice(){
        System.out.println("具体业务方法");
    }
}
