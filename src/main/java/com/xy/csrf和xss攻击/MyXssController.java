package com.xy.csrf和xss攻击;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @fileName:MyXssController
 * @author:xy
 * @date:2020/4/8
 * @description:
 */
@Controller
public class MyXssController {
    /**
     * 跨域攻击测试由于我所有代码写在一个项目 所以 要application.properties配置不同环境
     * MyXssController这个是8081 DiscussController是8080
     * XSS攻击模拟还是挺简单的，防御最简单就是设置字符串检测发现<script>或其他的脚本的过滤掉
     * 如果是针对cookie 可以设置httponly
     */

    @RequestMapping("/xss")
    @ResponseBody
    public String xss(String msg) {
        //模拟获取cookie 保存到某个地方我
        // 这里打印
        System.out.println(msg);
        return msg;
    }
}
