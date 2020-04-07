package com.xy.param_valid;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @fileName:ValidController
 * @author:xy
 * @date:2019/9/8
 * @description:
 */
@RestController
public class ValidController {
    private User r1=new User(1,"xx",33,4444);//测试jrebel
    @RequestMapping("/valid")
    public String valid(@Validated User user, BindingResult result, HttpServletRequest request, HttpSession httpSession){//
        System.out.println("______"+request.isRequestedSessionIdFromCookie());
//        System.out.println(httpSession.getAttribute("xy"));
//        if (httpSession.getAttribute("xy")==null){
//            httpSession.setAttribute("xy", "xy");
//        }
        System.out.println(r1.getNum());
        r1=new User(1,"xx",33,4444);
        System.out.println(r1.getNum());
        if (result.hasErrors()) {
            FieldError fieldError = result.getFieldError();
            return fieldError.getDefaultMessage();
        }
        return "123";
    }

    @RequestMapping(value = "/xy")
    public String test(HttpServletRequest request,HttpServletResponse response,@RequestParam("name") String name) {
        response.setHeader("Content-Length","100");
        response.addHeader("xxx","zzz");
        System.out.println(request.getContentLength());
        return name;
    }
}
