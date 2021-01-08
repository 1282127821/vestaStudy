package com.xy.跨域;/**
 * @author xy
 * @date 2021/1/8
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @fileName:CrossController
 * @author:xy
 * @date:2021/1/8
 * @description:
 */
@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class CrossController {
    @RequestMapping("/login")
    @ResponseBody
    public String login() {
        return "返回的数据";
    }

}
