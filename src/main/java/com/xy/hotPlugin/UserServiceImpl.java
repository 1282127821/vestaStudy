package com.xy.hotPlugin;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @fileName:UserServiceImpl
 * @author:xy
 * @date:2019/7/14
 * @description:
 */
@Component
public class UserServiceImpl implements UserService , BeanNameAware {

    @Override
    public void hello(){
        System.out.println("hello");
    }

    @Override
    public void setBeanName(String name) {
        //这个在这里没啥用，只是我想测试下BeanNameAware的作用
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()"+name);
    }
}
