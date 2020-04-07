package com.xy.spring懒加载验证;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @fileName:B
 * @author:xy
 * @date:2019/9/13
 * @description:
 */
@Component
public class B {
    public A a;

    public B(@Lazy A a) {
        System.out.println(1);
        this.a = a;
    }

    public void getName() {
        System.out.println(1);
    }

    public A getA() {
        return a;
    }
    public String getx() {
        return "hello";
    }
}
