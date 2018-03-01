package com.ou.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跳转到相应组件
 *
 * @author: kpkym
 * date: 2018/3/1
 * time: 14:35
 */
@Controller
@RequestMapping("component")
public class CommonComponentController {
    @RequestMapping("header")
    public String head() {
        return "component/header";
    }

    @RequestMapping("navigator")
    public String navigator() {
        return "component/navigator";
    }

    @RequestMapping("pagination")
    public String pagination() {
        return "component/pagination";
    }
}