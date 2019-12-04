package com.xxx.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisPatcherController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/itemDetail")
    public String itemDetail() {
        return "itemDetail";
    }

    @GetMapping("/adminLogin")
    public String adminLogin() {
        return "adminLogin";
    }
}
