package com.ou.mall.util;

import com.ou.mall.bean.Msg;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * BindingResult 工具
 *
 * @author: kpkym
 * date: 2018/3/5
 * time: 11:43
 */
public class ResultUtils {
    /**
     * 检查JSR303验证结果
     *
     * @param result
     * @return
     */
    public static Msg returnFaliure(BindingResult result) {
        FieldError fieldError = result.getFieldError();
        String message = fieldError.getDefaultMessage();
        return Msg.failure(message);
    }
}