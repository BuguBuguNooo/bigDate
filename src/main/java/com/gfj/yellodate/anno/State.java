package com.gfj.yellodate.anno;

import com.gfj.yellodate.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

/**
 * @author gefangjie
 */
@Documented//元注解，用于描述注解的使用范围
@Constraint(
        validatedBy = {StateValidation.class}//指定校验逻辑的类
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface State {
    //提供校验失败后的提示信息
    String message() default "state参数的值只能是已发布或草稿";
    //指定分组
    Class<?>[] groups() default {};
    //指定负载 获取到state的附加信息
    Class<? extends Payload>[] payload() default {};
}
