package com.xy.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @fileName:Configuration
 * @author:xy
 * @date:2019/7/13
 * @description:
 */
@Configuration
@ComponentScan("com.xy.aop")
@EnableAspectJAutoProxy
public class ConfigurationClass {
    /**
     *今天真是犯了一个蠢逼错误啊，一开始不管怎么我说怎么 spring aop功能一直不生效
     * 后来才发现网上的案例都是基于xml注解的，他们都在注解里面写上了
     * <!-- 开启aop注解方式，此步骤s不能少，这样java类中的aop注解才会生效 -->
     * <aop:aspectj-autoproxy/>
     * 而我这里由于是springboot的项目，而我自己又没有基于配置类方式(就是没写xml但是一开始又没有2
     * 配置类导致的，因为spring aop默认是关闭的，所以必须指定他开启)
     *
     * 至于为嘛关闭默认aop，其实你了解他的spring过程就知道了，因为我们知道spring使用切入点方式，指定
     * 哪些需要被代理，然后代理前后做什么，那么也就是说如果开启aop 他需要做很多初始化工作，所以默认
     * 不使用和aop相关的功能的话，他不开启的(事务必须开始aop否则事务失败)
     * 然后当你开启，spring在实例化的时候需要判断你这个类是否需要被代理(根据切入点表达式判断),如果需要
     * 哪些方法会被代理(依旧根据切入点表达式来)，这样他好生成代理类的逻辑(因为代理类说白了是要在内存中
     * 生成一个类的，其中这个类方法和被代理类方法一致。)
     * 然后spring将代理类实例化并放入spring容器中，这样我们通过spring容器拿到的是代理类而非被代理的类。
     * 这个你通过打开关闭aop功能@EnableAspectJAutoProxy debug查看你拿到的那个类是否是代理类就知道了。
     * 而我之所以知道打开aop的功能注解是@EnableAspectJAutoProxy这个，是因为spring都是这么规定的而已。
     */
}
