package com.xy.csrf和xss攻击;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.thymeleaf.expression.Lists;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @fileName:man
 * @author:xy
 * @date:2020/4/10
 * @description:
 */
public class man {

    public static <T> T get(Long l) {
        String a = "2";
        Integer b = 1;
        T t;
        t = (T) a;
        T t2;
        t2 = (T) b;
        System.out.println(t);
        System.out.println(t2);
        return (T) l;
    }

    public static void main(String[] args) {

        Long l = 1L;
        Object o = get(l);
        System.out.println(o);

        Properties properties = System.getProperties();

        String property = System.getProperty("user.dir");
        System.out.println(property);

        FanXin2<String> fanXin = new FanXin2<String>();
        Type typeParameter = ((ParameterizedType) fanXin.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        TypeVariable<? extends Class<? extends FanXin>> typeParameter = fanXin.getClass().getTypeParameters()[0];
        //由于编译后泛型擦除了所以他只记录了fanXin对象的类的泛型 T 而不会记录fanXin对象的实际泛型 这个是他和c#等泛型区别
        //那么我们如果想要知道对象的泛型实际类型怎么办？
        System.out.println(typeParameter);
        FanXin<String> fanXin2 = new FanXin<String>() {
        };
        Type typeParameter2 = ((ParameterizedType) fanXin2.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(typeParameter2);
        String s = JSON.parseObject("", new TypeReference<String>() {
        });
//        Class<List> listClass = List<String>.class;


    }
}

class FanXin2<T> extends FanXin<T> {

}

class FanXin<T> {
}
