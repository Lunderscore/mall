package com.ou.mall.controller;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.UserInfo;
import com.ou.mall.service.UserInfoService;
import com.ou.mall.util.ResultUtils;
import com.ou.mall.util.SessionUtils;
import com.ou.mall.validtion.RechargeValidtion;
import com.sun.imageio.plugins.common.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageInputStreamImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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
    public Msg recharge(HttpSession session, @Validated(RechargeValidtion.class) UserInfo userInfo, BindingResult result) {
        if (result.hasErrors()) {
            return ResultUtils.returnFaliure(result);
        }
        Integer uid = SessionUtils.getUserId(session);
        userInfoService.recharge(userInfo, uid);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "avatat", method = RequestMethod.POST)
    public Msg avatat(MultipartFile image, HttpServletRequest request) throws IOException {
        if (null == image) {
            return Msg.failure("图片不能为空");
        }
        BufferedImage read = ImageIO.read(image.getInputStream());
        if (null == read) {
            return Msg.failure("此文件不是图片");
        }
        String realPath = request.getServletContext().getRealPath("/");
        Integer userId = SessionUtils.getUserId(request.getSession());
        userInfoService.insertAvatar(realPath, image, userId);
        return Msg.success();
    }

}