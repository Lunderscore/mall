package com.xxx.mall.controller;

import com.xxx.mall.bean.Msg;
import com.xxx.mall.bean.UploadedImageFile;
import com.xxx.mall.bean.po.User;
import com.xxx.mall.bean.po.UserExample;
import com.xxx.mall.service.UserService;
import com.xxx.mall.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    HttpSession session;

    /*
     * 在注册用户的时候查看是否存在该用户
     */
    @ResponseBody
    @RequestMapping("/users/{username}")
    public Msg hasUser(@PathVariable("username") String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUserUsernameEqualTo(username);
        List<User> selectByExample = userService.selectByExample(example);

        if (selectByExample.isEmpty()) {
            return Msg.success();
        }
        return Msg.failure();
    }

    /*
     * 更新用户的信息
     */
    @RequestMapping(value = "user")
    public String update(User user) {
        User userSession = (User) session.getAttribute("userSession");
        Integer userId = userSession.getUserId();
        user.setUserId(userId);
        userService.updateByPrimaryKeySelective(user);

        updateUserSession();
        return "redirect:home";
    }

    /*
     * 上传用户头像
     */
    @RequestMapping(value = "avatar")
    public String uploadavatar(UploadedImageFile image) throws IllegalStateException, IOException {
        User user = (User) (session.getAttribute("userSession"));
        Integer userID = user.getUserId();
        String id = userID.toString();
        String avatarPath = session.getServletContext().getRealPath("/data/img/userAvatar/");
        String newImageName = ImageUtil.transfer(image, avatarPath, id);

        if (newImageName == null) {
            return "redirect:home";
        }
        user.setUserAvatar("data/img/userAvatar/" + newImageName);
        update(user);
        return "redirect:home";
    }

    /*
     * 用户对余额的操作
     */
    @ResponseBody
    @RequestMapping(value = "money")
    public Msg payment(@RequestParam(value = "mid", defaultValue = "0") Double payMoney
            , @RequestParam(value = "type", defaultValue = "0") Integer type) {
        User user = (User) session.getAttribute("userSession");
        if (payMoney == null || "".equals(payMoney)) {
            return Msg.failure().add("msg", "操作错误");
        } else if (user == null) {
            return Msg.failure().add("msg", "你还没有登录");
        } else if (type == 1) {
            payMoney = -payMoney;
        }

        Integer uid = user.getUserId();
        userService.addMoney(payMoney, uid);
        updateUserSession();

        return Msg.success();
    }

    public void updateUserSession() {
        User user = (User) (session.getAttribute("userSession"));
        Integer userID = user.getUserId();

        User u = userService.selectByPrimaryKey(userID);
        session.setAttribute("userSession", u);
    }

}
