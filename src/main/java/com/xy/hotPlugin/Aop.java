package com.xy.hotPlugin;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @fileName:Aop
 * @author:xy
 * @date:2019/7/14
 * @description:
 */
@Aspect
@Component
public class Aop {
    /** 基于表达式方法方式*/
    @Pointcut("execution(* com.xy.hotPlugin.UserService.*(..))")
    public void pointcut() {

    }
    /** 没有任何通知就是导致那边不能触发代理 */
    @After("pointcut()")
    public void doAfter(){

    }
}
