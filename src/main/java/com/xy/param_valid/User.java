package com.xy.param_valid;


import com.xy.param_valid.自定义校验注解.Xy;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User {
    @Min(value = 3,message = "最少3个")
    private int id;
    @NotNull(message = "不能为null")
    @Xy
    private String name;

    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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
}
