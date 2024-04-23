package com.gfj.yellodate.validation;

import com.gfj.yellodate.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

//ConstraintValidator<给哪个注解提供校验规则，校验的数据类型>
public class StateValidation implements ConstraintValidator<State, String> {
    /**
     *
     * @param s 传入的校验数据
     * @param constraintValidatorContext
     * @return true:校验通过 false:校验失败
     */

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //校验逻辑
        if (s.equals("已发布") || s.equals("草稿")) {
            return true;
        }
        return false;
    }
}
