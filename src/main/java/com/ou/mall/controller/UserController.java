package com.ou.mall.controller;

import com.ou.mall.bean.Msg;
import com.ou.mall.bean.User;
import com.ou.mall.service.UserService;
import com.ou.mall.validation.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * UserController
 *
 * @author: kpkym
 * date: 2018/3/1
 * time: 0:40
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    /**
     * @param session
     * @param user
     * @param result
     * @return 成功 success 失败 failure
     */
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Msg login(HttpSession session, @Validated(UserLogin.class) User user, BindingResult result) {
        if (result.hasErrors()) {
            String defaultMessage = result.getFieldError().getDefaultMessage();
            return Msg.failure(defaultMessage);
        }
        User userSession = userService.login(user);
        if (null == userSession) {
            return Msg.failure("账号或密码错误");
        }
        session.setAttribute("user", userSession.getUid());
        return Msg.success();
    }

    /**
     * @param session
     * @param user
     * @param result
     * @return 成功 success 失败 failure
     */
    @ResponseBody
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public Msg register(HttpSession session, @Validated(UserLogin.class) User user, BindingResult result) {
        if (result.hasErrors()) {
            String defaultMessage = result.getFieldError().getDefaultMessage();
            return Msg.failure(defaultMessage);
        }
        // 注册成功 进入登录方法
        if (userService.register(user)) {
            return login(session, user, result);
        }
        return Msg.failure("failure");
    }


    // /*
    //  * 在注册用户的时候查看是否存在该用户
    //  */
    // @ResponseBody
    // @RequestMapping("/users/{username}")
    // public Msg hasUser(@PathVariable("username")String username){
    // 	UserExample example = new UserExample();
    // 	example.createCriteria().andUserUsernameEqualTo(username);
    // 	List<User> selectByExample = userService.selectByExample(example);
    //
    // 	if (selectByExample.isEmpty()){
    // 		return Msg.success();
    // 	}
    // 	return Msg.failure();
    // }
    //
    // /*
    //  * 更新用户的信息
    //  */
    // @RequestMapping(value="user")
    // public String update(User user){
    // 	User userSession = (User) session.getAttribute("userSession");
    // 	Integer userId = userSession.getUserId();
    // 	user.setUserId(userId);
    // 	userService.updateByPrimaryKeySelective(user);
    //
    // 	updateUserSession();
    //    return "redirect:home";
    // }
    //
    // /*
    //  * 上传用户头像
    //  */
    // @RequestMapping(value="avatar")
    // public String uploadavatar(UploadedImageFile image) throws IllegalStateException, IOException{
    // 	User user = (User)(session.getAttribute("userSession"));
    // 	Integer userID = user.getUserId();
    // 	String id = userID.toString();
    // 	String avatarPath = session.getServletContext().getRealPath("/data/img/userAvatar/");
    //    String newImageName = ImageUtil.transfer(image, avatarPath, id);
    //
    //    if (newImageName == null){
    //        return "redirect:home";
    //    }
    //    user.setUserAvatar("data/img/userAvatar/"+newImageName);
    //    update(user);
    //    return "redirect:home";
    // }
    //
    // /*
    //  * 用户对余额的操作
    //  */
    // @ResponseBody
    // @RequestMapping(value="money")
    // public Msg payment(@RequestParam(value="mid", defaultValue="0") Double payMoney
    // 		, @RequestParam(value="type", defaultValue="0") Integer type){
    // 	User user = (User) session.getAttribute("userSession");
    // 	if (payMoney==null || "".equals(payMoney)){
    // 		return Msg.failure().add("msg", "操作错误");
    // 	}else if(user==null){
    // 		return Msg.failure().add("msg", "你还没有登录");
    // 	}else if (type == 1){
    // 		payMoney = -payMoney;
    // 	}
    //
    // 	Integer uid = user.getUserId();
    // 	userService.addMoney(payMoney, uid);
    // 	updateUserSession();
    //
    // 	return Msg.success();
    // }
    //
    // public void updateUserSession(){
    // 	User user = (User)(session.getAttribute("userSession"));
    // 	Integer userID = user.getUserId();
    //
    // 	User u = userService.selectByPrimaryKey(userID);
    // 	session.setAttribute("userSession", u);
    // }

}
