package com.xy.ajax测试;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "HelloAjax#say1";
    }

    @RequestMapping("/say2")
    @ResponseBody
    public String say2() {
        return "HelloAjax#say2";
    }
}
