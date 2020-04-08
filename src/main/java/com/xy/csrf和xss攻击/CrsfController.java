package com.xy.csrf和xss攻击;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @fileName:CrsfController
 * @author:xy
 * @date:2020/4/8
 * @description:
 */
@Controller
public class CrsfController {

    @RequestMapping("/fish")
    public String fish() {
        return "crsf";
    }

}
