package com.xy.param_valid.自定义校验注解;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @fileName:XyRule
 * @author:xy
 * @date:2019/9/8
 * @description:
 */
public class XyRule implements ConstraintValidator<Xy, String> {

    @Override
    public void initialize(Xy constraintAnnotation) {
        //初始化工作，这里就可以拿到某个属性上面的注解信息了，我这里没有做初始化工作简单打印下
        System.out.println("init get data:" + constraintAnnotation.message());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.equals("xy")) {
            return true;
        }
        return false;
    }
}
