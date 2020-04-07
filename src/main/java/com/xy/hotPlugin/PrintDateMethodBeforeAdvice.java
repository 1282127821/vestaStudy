package com.xy.hotPlugin;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @fileName:MethodBeforeAdvice
 * @author:xy
 * @date:2019/7/14
 * @description:
 */
public class PrintDateMethodBeforeAdvice implements MethodBeforeAdvice {
    /** 每个方法的访问次数*/
    private Map<String,Integer> countMap=new HashMap<>();
    /** 总访问次数*/
    private int allCount;

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        count(method);
        System.out.println(String.format("方法%s执行次数%s0",method.getName(),countMap.get(method.getName()) ));
    }

    private void count(Method method) {
        String methodName = method.getName();
        //之前统计过该方法+1,之前没有统计过该方法放进去+1
        if (countMap.get(methodName)!=null) {
            countMap.put(methodName, countMap.get(methodName)+1);
            allCount++;
        }else {
            countMap.put(methodName,1);
            allCount++;
        }

    }
}
