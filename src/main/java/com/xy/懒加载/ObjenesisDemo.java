package com.xy.懒加载;

import org.junit.jupiter.api.Test;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisBase;
import org.springframework.objenesis.ObjenesisSerializer;
import org.springframework.objenesis.ObjenesisStd;
import org.springframework.objenesis.instantiator.ObjectInstantiator;
import org.springframework.objenesis.strategy.SingleInstantiatorStrategy;

/**
 * @fileName:ObjenesisDemo
 * @author:xy
 * @date:2020/9/4
 * @description:
 */
public class ObjenesisDemo {
    @Test
    public void test() {
        //建立一个标准版standard Objenesis对象
        Objenesis objenesis = new ObjenesisStd();
        //指定需要生成的对象
        ObjectInstantiator<ALazyDemo> instantiatorOf = objenesis.getInstantiatorOf(ALazyDemo.class);
        ALazyDemo aLazyDemo = instantiatorOf.newInstance();
        ALazyDemo aLazyDemo2 = instantiatorOf.newInstance();
        //这样生成的对象就绕过了构造方法
        System.out.println(aLazyDemo);//com.xy.懒加载.ALazyDemo@6950e31
        System.out.println(aLazyDemo2);//com.xy.懒加载.ALazyDemo@b7dd107

        Objenesis objenesis2 = new ObjenesisStd(true);
        ObjectInstantiator<ALazyDemo> instantiatorOf2 = objenesis2.getInstantiatorOf(ALazyDemo.class);
        ALazyDemo aLazyDemo3 = instantiatorOf2.newInstance();
        ALazyDemo aLazyDemo4 = instantiatorOf2.newInstance();
        System.out.println(aLazyDemo3);//com.xy.懒加载.ALazyDemo@52f759d7
        System.out.println(aLazyDemo4);//com.xy.懒加载.ALazyDemo@7cbd213e

        //上面的都是创建标准的Objenesis对象， 其实这是一个封装，里面new StdInstantiatorStrategy() 是这个策略
        //他还有很作策略 大致猜测就是 比如SingleInstantiatorStrategy这个应该就是生成单例？
//        Objenesis objenesis3 =new ObjenesisBase(new SingleInstantiatorStrategy())
    }
}
