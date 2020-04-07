package com.xy.spring懒加载验证;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @fileName:A
 * @author:xy
 * @date:2019/9/13
 * @description:
 */
@Component
public class A {
    private B b;

    public A(@Lazy B b) {
        System.out.println(2);
        this.b = b;
        System.out.println(b);
    }

    public B getB() {
        return b;
    }

}
