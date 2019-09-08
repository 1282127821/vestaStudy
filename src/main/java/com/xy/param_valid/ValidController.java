package com.xy.param_valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @fileName:ValidController
 * @author:xy
 * @date:2019/9/8
 * @description:
 */
@RestController
public class ValidController {
    @RequestMapping("/valid")
    public String valid(@Validated User user, BindingResult result){//
        if (result.hasErrors()) {
            FieldError fieldError = result.getFieldError();
            return fieldError.getDefaultMessage();
        }
        return "123";
    }
}
