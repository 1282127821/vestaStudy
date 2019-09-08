package com.xy.param_valid.自定义校验注解;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = {XyRule.class})
public @interface Xy {//检查属性是否是xy字符

    /**
     * 注意这个注解由于继承了@Constraint注解所以必须要有如下参数
     * 开始我以为只写一个message参数就行，发现一直报错，其实控制台
     * 有提示，但是我一开始没注意。
     * 具体你用不用无所谓，但是一定要有，因为spring内部会用,所以你给他一个默认值即可(没有默认值就需要自己填)
     * javax.validation.ConstraintDefinitionException: HV000074: com.xy.param_valid.自定义校验注解.Xy contains Constraint annotation, but does not contain a groups parameter.
     * javax.validation.ConstraintDefinitionException: HV000074: com.xy.param_valid.自定义校验注解.Xy contains Constraint annotation, but does not contain a payload parameter.
     */
    //是否必须
    boolean required() default false;

    String message() default "字符串必须是xy";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
