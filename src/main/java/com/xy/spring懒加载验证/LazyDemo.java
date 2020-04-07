package com.xy.spring懒加载验证;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @fileName:Lazyemo
 * @author:xy
 * @date:2019/9/13
 * @description:
 */
public class LazyDemo {
    public static void main(String[] args) {
        String json="{id:1,name:2}";
        User user = JSON.parseObject(json, User.class);
        System.out.println(user);
    }
    @Test
    public void test(){
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext("com.xy.spring懒加载验证");
        B bean = ctx.getBean(B.class);
        A bean1 = ctx.getBean(A.class);

        System.out.println(bean);
        System.out.println(bean1.getB().a);
        System.out.println(bean1.getB());
        System.out.println(bean1.getB().getx());
    }
}
class User{
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
