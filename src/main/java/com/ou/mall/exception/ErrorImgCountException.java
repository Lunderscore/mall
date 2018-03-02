package com.ou.mall.exception;

/**
 * 商品信息超过指定数量
 *
 * @author: kpkym
 * date: 2018/3/2
 * time: 20:49
 */
public class ErrorImgCountException extends CustomException {
    public ErrorImgCountException(String message) {
        super(message);
    }
}