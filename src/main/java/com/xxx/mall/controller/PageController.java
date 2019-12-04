package com.xxx.mall.controller;
/*
 * 本类主要负责页面跳转相关的逻辑
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.mall.bean.Msg;
import com.xxx.mall.bean.po.*;
import com.xxx.mall.service.ProductService;
import com.xxx.mall.service.UserOrderService;
import com.xxx.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@Controller
public class PageController {
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    UserOrderService userOrderService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;


    /*
     * 主页每页显示十八条信息
     */
    @RequestMapping(value = {"index", "/"})
    public String index(@RequestParam(value = "keyword", required = false) String keyword
            , @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 使用PageHelper插件进行分页操作
        // 设置每页有15条数据
        pn = pn == 0 ? 1 : pn;
        PageHelper.startPage(pn, 18);
        ProductExample example = new ProductExample();
        ProductExample.Criteria createCriteria = example.createCriteria();

        // 查看是否关键词搜索
        if ("".equals(keyword) || keyword == null) {
            keyword = null;
        } else {
            createCriteria.andProductTitleLike("%" + keyword + "%");
        }
        // 显示有图片1的商品
        // 商品状态 0 表示为上架状态， 1为下架状态， -1为删除  状态
        createCriteria.andProductImg1IsNotNull();
        createCriteria.andProductStatusEqualTo(0);
        List<Product> all = productService.selectByExample(example);   //根据条件选择查询
        PageInfo<Product> page = new PageInfo<Product>(all, 5);  // 分页条最多有5个
        request.setAttribute("pages", page);    // 将数据放入request 作用于供前台使用
        return "index";                        // 转发回主页
    }


    @ResponseBody
    @RequestMapping(value = "loglogin")
    public Msg login(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return Msg.failure().add("msg", "账号或密码错误");
        }
        user = userService.login(user);
        session.setAttribute("userSession", user);
        if (user == null) {
            return Msg.failure().add("msg", "账号或密码错误");
        }
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "regregister")
    public Msg register(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return Msg.failure();
        }
        user.setUserMoney(0.0);
        userService.insert(user);
        return login(user, result);
    }

    @RequestMapping(value = "logOut")
    public String logOut() {
        session.removeAttribute("userSession");
        return "redirect:"+ request.getServletContext().getContextPath() + "/login";
    }

    @RequestMapping("shoppingCar")
    public String shoppingCar() {

        Integer uid = ((User) session.getAttribute("userSession")).getUserId();

        UserOrderExample example = new UserOrderExample();
        example.createCriteria().andOrderStatusEqualTo(0).andOrderUidEqualTo(uid);

        List<UserOrder> shoppingCar = userOrderService.selectByExampleWithProduct(example);
        request.setAttribute("shoppingCar", shoppingCar);
        return "shoppingCar";
    }

    @RequestMapping("payment")
    public String payment(@RequestParam("uoid") String uoid, @RequestParam("totalMoney") String totalMoney,
                          UserOrder userOrder) {
        if ("".equals(uoid) || "".equals(totalMoney) || uoid == null || totalMoney == null) {
            return "redirect:index.jsp";
        }

        String[] uoids = uoid.split("-");
        for (String id : uoids) {
            userOrder.setOrderId(Integer.parseInt(id));
            Date orderDateTime = new Date(System.currentTimeMillis());
            userOrder.setOrderDateTime(orderDateTime);
            userOrderService.updateOrderByPrimaryKey(userOrder);
        }

        request.setAttribute("totalMoney", totalMoney);
        request.setAttribute("uoid", uoid);
        return "payment";
    }


    @RequestMapping("userOrder")
    public String userOrderPage(@RequestParam(value = "type", defaultValue = "0") Integer type,
                                @RequestParam(value = "keyword", required = false) String keyword, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
//		设置分页大小
        PageHelper.startPage(pn, 5);
        User user = (User) session.getAttribute("userSession");
        Integer uid = user.getUserId();

        UserOrderExample example = new UserOrderExample();
        UserOrderExample.Criteria createCriteria = example.createCriteria();
        if (type == 0) {
            createCriteria.andOrderStatusNotEqualTo(-1);
            createCriteria.andOrderStatusNotEqualTo(0);
        } else {
            createCriteria.andOrderStatusEqualTo(type);
        }
        if (keyword != null && !"".equals(keyword)) {
            createCriteria.andProductTitleLike(keyword);
        }
        createCriteria.andOrderUidEqualTo(uid);
        List<UserOrder> selectByExampleWithProduct = userOrderService.selectByExampleWithProduct(example);
        PageInfo<UserOrder> pageInfo = new PageInfo<>(selectByExampleWithProduct, 5);
        request.setAttribute("pages", pageInfo);
        return "userOrder";
    }

    @RequestMapping("adminOrder")
    public String adminOrderPage(@RequestParam(value = "type", defaultValue = "0") Integer type,
                                @RequestParam(value = "keyword", required = false) String keyword, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        if (session.getAttribute("adminSession") == null) {
            return "adminLogin";
        }

//		设置分页大小
        PageHelper.startPage(pn, 5);

        UserOrderExample example = new UserOrderExample();
        UserOrderExample.Criteria createCriteria = example.createCriteria();
        if (type == 0) {
            createCriteria.andOrderStatusNotEqualTo(-1);
            createCriteria.andOrderStatusNotEqualTo(0);
        } else {
            createCriteria.andOrderStatusEqualTo(type);
        }
        if (keyword != null && !"".equals(keyword)) {
            createCriteria.andProductTitleLike(keyword);
        }
        List<UserOrder> selectByExampleWithProduct = userOrderService.selectByExampleWithProduct(example);
        PageInfo<UserOrder> pageInfo = new PageInfo<>(selectByExampleWithProduct, 5);
        request.setAttribute("pages", pageInfo);
        return "adminOrder";
    }

    @RequestMapping("home")
    public String home() {
        return "home";
    }
}
