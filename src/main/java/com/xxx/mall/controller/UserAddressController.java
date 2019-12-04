package com.xxx.mall.controller;

import com.xxx.mall.bean.Msg;
import com.xxx.mall.bean.po.User;
import com.xxx.mall.bean.po.UserAddress;
import com.xxx.mall.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserAddressController {
    @Autowired
    UserAddressService userAddressService;

    @ResponseBody
    @RequestMapping(value = "userAddress")
    public Msg updateAddress(UserAddress address, HttpSession session) {
        User user = (User) session.getAttribute("userSession");
        Integer userID = user.getUserId();

        userAddressService.updateAddress(address, userID);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "getUserAddress")
    public Msg getUserAddress(HttpSession session) {
        User user = (User) session.getAttribute("userSession");
        Integer userID = user.getUserId();

        UserAddress selectUserAddressByUid = userAddressService.selectUserAddressByUid(userID);
        return Msg.success().add("address", selectUserAddressByUid);
    }
}
