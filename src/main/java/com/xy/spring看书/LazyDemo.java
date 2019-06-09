package com.xy.spring看书;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @fileName:LazyDemo
 * @author:xy
 * @date:2019/6/8
 * @description:
 */
@Component
@Lazy
public class LazyDemo {
    /**
     *@Lazy表示延迟构造，如果我们不用到他就不会进行实例化放入spring容器中
     */
    public LazyDemo() {
        System.err.println("LazyDemo被构造了!");
    }
}
