package com.xy.ajax测试;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @fileName:HelloAjax
 * @author:xy
 * @date:2020/11/22
 * @description:
 */
@Controller
public class HelloAjaxDemo {

    @RequestMapping("/index")
    public String index() {
        return "ajaxDemo";
    }
    @RequestMapping("/say1")
    @ResponseBody
    public String say1() {
        System.out.println("say1请求进入："+new Date());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "HelloAjax#say1";
    }
    @RequestMapping("/say2")
    @ResponseBody
    public String say2() {
        System.out.println("say2请求进入："+new Date());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "HelloAjax#say2";
    }
    @RequestMapping("/say3")
    @ResponseBody
    public String say3() {
        System.out.println("say3请求进入："+new Date());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "HelloAjax#say3";
    }
    @RequestMapping("/say4")
    @ResponseBody
    public String say4() {
        System.out.println("say4请求进入："+new Date());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "HelloAjax#say4";
    }
    @RequestMapping("/say5")
    @ResponseBody
    public String say5() {
        System.out.println("say5请求进入："+new Date());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "HelloAjax#say5";
    }
    @RequestMapping("/say6")
    @ResponseBody
    public String say6() {
        System.out.println("say6请求进入："+new Date());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "HelloAjax#say6";
    }

    @RequestMapping("/say7")
    @ResponseBody
    public String say7() {
        System.out.println("say7请求进入："+new Date());
        return "HelloAjax#say7";
    }
}
