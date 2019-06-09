package com.xy.spring看书;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @fileName:DestoryDemo
 * @author:xy
 * @date:2019/6/8
 * @description:
 */
@Component
public class DestoryDemo {
    /**
     *销毁方法不会主动被调用，只有我们调用了ApplicationContext#destory
     * 但是这个方法只会调用具体的某一个,但是现在不推荐这个方法过期了
     * @see AbstractApplicationContext#destroy()
     * 现在推荐使用钩子
     * @see AbstractApplicationContext#registerShutdownHook()
     */

    @PreDestroy
    public void destory(){
        System.out.println("销毁被调用!");
    }
}
