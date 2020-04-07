package com.xy.hotPlugin;

import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;

/**
 * @fileName:Demo
 * @author:xy
 * @date:2019/7/17
 * @description:
 */
public class Demo {
    static User user=new User(10);
    @Test
    public void test(){
        Demo demo=new Demo();
        demo.invoke((x)->{
            x.setNum(100);
            System.out.println(x.getNum());
            System.out.println(this);
        });
        System.out.println(user.getNum());
    }


    public void invoke(Function func){
        func.m(user);
    }
}
interface Function{
    void m(User s);
}
class User{
    private int num;

    public User(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
