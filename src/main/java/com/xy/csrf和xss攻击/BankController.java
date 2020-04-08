package com.xy.csrf和xss攻击;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @fileName:BankController
 * @author:xy
 * @date:2020/4/8
 * @description:
 */
@Controller
public class BankController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpSession session) {
        //登陆的session
        //由于我这里 都是localhost导致 session默认所有localhost都可以访问
        //因为cookie默认domain是当前域名 所以这里使用cookie代替session没办法
        //突然想到了我们电脑就有两个ip一个使用localhost一个使用 192.168.43.189即可(这个可能会变)
        session.setAttribute("login", "xy-123");
        return "登陆成功";
    }

    @RequestMapping("/transfer")
    @ResponseBody
    public String transfer(HttpSession session, int account, int amount) {
        String login = (String) session.getAttribute("login");
        if (login == null) {
            return "没有登录,不能进行转账操作";
        }
        String msg = "给" + account + "转账" + amount + "成功";
        return msg;
    }

    @RequestMapping("/index5")
    public String index() {
        return "bank";
    }
}
