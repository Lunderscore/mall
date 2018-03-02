package com.ou.mall.exception;

/**
 * 注册时存在该用户名
 *
 * @author: kpkym
 * date: 2018/3/2
 * time: 22:53
 */
public class HasUsernameException extends CustomException {
    public HasUsernameException(String message) {
        super(message);
    }
}