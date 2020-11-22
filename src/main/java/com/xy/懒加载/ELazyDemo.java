package com.xy.懒加载;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @fileName:ELazyDemo
 * @author:xy
 * @date:2020/9/6
 * @description:
 */
@Component
public class ELazyDemo {
    @Autowired
    private ELazyDemo eLazyDemo;
}
