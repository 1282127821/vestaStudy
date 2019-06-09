package com.xy.spring看书;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @fileName:BeanNameDemo
 * @author:xy
 * @date:2019/6/8
 * @description:
 */
@Component
public class BeanNameDemo implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println(name);
    }
}
