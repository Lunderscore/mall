package com.ou.mall.controller;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.UserAddress;
import com.ou.mall.service.UserAddressService;
import com.ou.mall.util.ResultUtils;
import com.ou.mall.util.SessionUtils;
import com.ou.mall.validtion.AddUserAddressValidtiom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: kpkym
 * date: 2018/3/12
 * time: 12:46
 */
@Controller
public class UserAddressController {
    @Autowired
    UserAddressService userAddressService;

    @ResponseBody
    @RequestMapping(value = "userAddresses", method = RequestMethod.GET)
    public Msg listUserAddress(HttpSession session) {
        Integer uid = SessionUtils.getUserId(session);
        List<UserAddress> userAddresses = userAddressService.listUserAddress(uid);
        return Msg.success().add("userAddresses", userAddresses);
    }

    @ResponseBody
    @RequestMapping(value = "userAddresses/{uaid}", method = RequestMethod.GET)
    public Msg getUserAddress(@PathVariable Integer uaid) {
        UserAddress userAddress = userAddressService.getUserAddress(uaid);
        return Msg.success().add("userAddres", userAddress);
    }

    @ResponseBody
    @RequestMapping(value = "userAddresses", method = RequestMethod.POST)
    public Msg insertUserAddress(HttpSession session, @Validated(AddUserAddressValidtiom.class) UserAddress userAddress, BindingResult result) {
        if (result.hasErrors()) {
            return ResultUtils.returnFaliure(result);
        }
        Integer userId = SessionUtils.getUserId(session);
        userAddressService.insertUserAddress(userId, userAddress);
        return Msg.success();
    }
}