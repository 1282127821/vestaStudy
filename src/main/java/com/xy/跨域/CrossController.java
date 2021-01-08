package com.xy.跨域;/**
 * @author xy
 * @date 2021/1/8
 */

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @fileName:CrossController
 * @author:xy
 * @date:2021/1/8
 * @description:
 */
@Controller
@CrossOrigin(origins = "*" ,allowCredentials = "true",maxAge = 3600)
public class CrossController {
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return "获取不到cookie";
        }
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + ">>" + cookie.getValue());
        }
        return "返回的数据";
    }

    @RequestMapping("/index")
    @ResponseBody
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + ">>" + cookie.getValue());
        }
        return "index正常方式";
    }

}
