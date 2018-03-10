package com.ou.mall.controller;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.UserInfo;
import com.ou.mall.service.UserInfoService;
import com.ou.mall.util.ResultUtils;
import com.ou.mall.util.SessionUtils;
import com.ou.mall.validtion.RechargeValidtion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author: kpkym
 * date: 2018/3/8
 * time: 9:37
 */
@Controller
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    @ResponseBody
    @RequestMapping(value = "userInfos", method = RequestMethod.GET)
    public Msg getUserInfo(HttpSession session) {
        Integer uid = SessionUtils.getUserId(session);
        UserInfo userInfo = userInfoService.getUserInfo(uid);
        return Msg.success().add("userInfo", userInfo);
    }

    @ResponseBody
    @RequestMapping(value = "userInfos", method = RequestMethod.PUT)
    public Msg updateUserInfo(HttpSession session, @Validated(RechargeValidtion.class) UserInfo userInfo, BindingResult result) {
        if (result.hasErrors()) {
            return ResultUtils.returnFaliure(result);
        }
        Integer uid = SessionUtils.getUserId(session);
        userInfoService.recharge(userInfo, uid);
        return Msg.success();
    }
}