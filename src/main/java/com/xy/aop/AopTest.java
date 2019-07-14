package com.xy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @fileName:AopTesr
 * @author:xy
 * @date:2019/7/13
 * @description:
 */
@Aspect
@Component
public class AopTest {
    /** 基于表达式方法方式*/
    @Pointcut("execution(* com.xy.aop.*.*(..))")
    public void pointcut() {

    }
    /** 基于注解方式,也就是对应的方法有这个注解才会开启aop*/
    @Pointcut("@annotation(com.xy.aop.Log)")
    public void pointcut2() {

    }

    @After("pointcut()")
    public void doAfter(JoinPoint name){
        System.out.println(name.getThis());
        System.out.println("After---------------------------");
    }
    @Before("pointcut2()")
    public void doBefore(){
        System.out.println("Before---------------------------");
    }

}
