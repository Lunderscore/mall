package com.ou.mall.util;

import javax.servlet.http.HttpSession;

/**
 * @author: kpkym
 * date: 2018/3/8
 * time: 9:42
 */
public class SessionUtils {
    public static Integer getUserId(HttpSession session) {
        return (Integer) session.getAttribute("user");
    }
}