package com.xy.懒加载;

import org.junit.jupiter.api.Test;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisBase;
import org.springframework.objenesis.ObjenesisStd;
import org.springframework.objenesis.instantiator.ObjectInstantiator;
import org.springframework.objenesis.strategy.SerializingInstantiatorStrategy;
import org.springframework.objenesis.strategy.SingleInstantiatorStrategy;
import org.springframework.objenesis.*;
import org.springframework.objenesis.strategy.StdInstantiatorStrategy;

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
        //上面都是使用固定的策略，如果我们想使用其他策略就需要使用ObjenesisBase
        //NewInstanceInstantiator产生新的对象，然后会发现new一个传递进去的也就是这里的ALazyDemo对象，会调用构造 如果构造是私有的或者没有
        //午无参构造就报错
        Objenesis objenesis3 = new ObjenesisBase(new SingleInstantiatorStrategy(org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator.class));
        ObjectInstantiator<ALazyDemo> objenesis5 = objenesis3.getInstantiatorOf(ALazyDemo.class);
        ObjectInstantiator<ALazyDemo> objenesis6 = objenesis3.getInstantiatorOf(ALazyDemo.class);
//        System.out.println(objenesis5.newInstance());//com.xy.懒加载.ALazyDemo@2362f559
//        System.out.println(objenesis6.newInstance());//com.xy.懒加载.ALazyDemo@b2c9a9c

        //这个AccessibleInstantiator 可操作的实例化对象，看一下源码貌似比NewInstanceInstantiator
        //多了一个this.constructor.setAccessible(true) 也就是如果这个是私有的不会报错！！！ 但是依旧要有无参构造
        Objenesis objenesis4 = new ObjenesisBase(new SingleInstantiatorStrategy(org.springframework.objenesis.instantiator.basic.AccessibleInstantiator.class));
//        ObjectInstantiator<ALazyDemo> objenesis7 = objenesis4.getInstantiatorOf(ALazyDemo.class);
//        ObjectInstantiator<ALazyDemo> objenesis8 = objenesis4.getInstantiatorOf(ALazyDemo.class);
//        System.out.println(objenesis7.newInstance());
//        System.out.println(objenesis8.newInstance());

        //ConstructorInstantiator其实是AccessibleInstantiator父类
//        Objenesis objenesis9 = new ObjenesisBase(new SingleInstantiatorStrategy(org.springframework.objenesis.instantiator.basic.ConstructorInstantiator.class));
//        ObjectInstantiator<ALazyDemo> objenesis10 = objenesis9.getInstantiatorOf(ALazyDemo.class);
//        ObjectInstantiator<ALazyDemo> objenesis11 = objenesis9.getInstantiatorOf(ALazyDemo.class);
//        System.out.println(objenesis10.newInstance());
//        System.out.println(objenesis11.newInstance());
        //NullInstantiator创建一个空的null 根本就不走构造...因为不会进入类
        Objenesis objenesis12 = new ObjenesisBase(new SingleInstantiatorStrategy(org.springframework.objenesis.instantiator.basic.NullInstantiator.class));
        ObjectInstantiator<ALazyDemo> objenesis13 = objenesis12.getInstantiatorOf(ALazyDemo.class);
        System.out.println(objenesis13.newInstance());
        //ObjectInputStreamInstantiator 那么 ALazyDemo必须是一个可序列化的对象

        Objenesis objenesis14 = new ObjenesisBase(new SingleInstantiatorStrategy(org.springframework.objenesis.instantiator.basic.ObjectInputStreamInstantiator.class));
        ObjectInstantiator<ALazyDemo> objenesis15 = objenesis14.getInstantiatorOf(ALazyDemo.class);
        System.out.println(objenesis15.newInstance());

        //还有策略对象 只有下面四种，但是能够允许修改 Instantiator的只有SingleInstantiatorStrategy类型
        //其他的都是固定的。
        //BaseInstantiatorStrategy (org.springframework.objenesis.strategy) //抽象类
        //SerializingInstantiatorStrategy (org.springframework.objenesis.strategy)
        //SingleInstantiatorStrategy (org.springframework.objenesis.strategy)
        //StdInstantiatorStrategy (org.springframework.objenesis.strategy)

        Objenesis objenesis16 = new ObjenesisBase(new SerializingInstantiatorStrategy());
        ObjectInstantiator<ALazyDemo> objenesis17 = objenesis16.getInstantiatorOf(ALazyDemo.class);
        System.out.println(objenesis17.newInstance());
        Objenesis objenesis18 = new ObjenesisBase(new StdInstantiatorStrategy());
        ObjectInstantiator<ALazyDemo> objenesis19 = objenesis18.getInstantiatorOf(ALazyDemo.class);
        System.out.println(objenesis19.newInstance());

    }
}
