package com.xy.spring懒加载验证;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @fileName:dfsf
 * @author:xy
 * @date:2019/11/29
 * @description:
 */
public class dfsf {
    @Test
    public void test2() {
        List<U> list=new ArrayList<>();
        list.add(new U(1, 1));
        list.add(new U(3, 3));
        list.add(new U(5, 5));
        list.add(new U(4, 4));
        list.add(new U(9, 12));
        list.add(new U(9, 9));
        List<U> collect = list.stream().sorted(Comparator.comparing(U::getId).reversed()
                .thenComparing(Comparator.comparing(U::getAge).reversed())).collect(Collectors.toList());
        System.out.println(collect);

    }

    public static ConcurrentHashMap<Integer, U> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        map.put(1, new U(1, 1));
        Task task = new Task();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
            U u = dfsf.map.get(1);
            u.setId(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Task implements Runnable {

    @Override
    public void run() {
        U u = dfsf.map.get(1);
        int a=u.getId();
//        synchronized (this){
            if (u.getId() > 0) {
                System.out.println("true");
            }
            while (true){
                System.out.println(u.getId());
//                System.out.println(a);
            }
//            u.setId(0);
//        }
    }
}

class U {
    private int id;
    private int age;

    public U(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "U{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
