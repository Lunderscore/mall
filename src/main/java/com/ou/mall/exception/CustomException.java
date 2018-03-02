package com.ou.mall.exception;

/**
 * 个人自定义异常基类
 *
 * @author: kpkym
 * date: 2018/3/2
 * time: 20:48
 */
public abstract class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}