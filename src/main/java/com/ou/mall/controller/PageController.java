package com.ou.mall.controller;

import com.github.pagehelper.PageInfo;
import com.ou.mall.bean.Product;
import com.ou.mall.bean.User;
import com.ou.mall.bean.UserInfo;
import com.ou.mall.service.ProductService;
import com.ou.mall.service.UserInfoService;
import com.ou.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 本类主要负责页面跳转相关的逻辑
 *
 * @author: kpkym
 * date: 2018/3/1
 * time: 14:24
 */
@Controller
public class PageController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;

    @Value("${navigatePages.size}")
    Integer navigatePagesSize;

    /**
     * 主页商品信息
     *
     * @param keyword
     * @param pn
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model,
            @RequestParam(defaultValue = "") String keyword
            , @RequestParam(defaultValue = "1") Integer pn) {
        List<Product> all = productService.listProduct(pn, keyword);
        // 分页条最多有5个
        System.out.println(all);
        PageInfo<Product> page = new PageInfo<>(all, navigatePagesSize);
        model.addAttribute("pageInfo", page);
        return "index";
    }

    /**
     * 商品详情
     *
     * @param model
     * @param pid
     * @return
     */
    @RequestMapping(value = "productDetail", method = RequestMethod.GET)
    public String productDetail(Model model, @RequestParam Integer pid) {
        Product product = productService.getProduct(pid);
        model.addAttribute("product", product);
        return "productDetail";
    }

    /**
     * 个人主页
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        //TODO
        // Integer uid = (Integer) session.getAttribute("user");
        Integer uid = 1;
        User user = userService.getUser(uid);
        UserInfo userInfo = userInfoService.getUserInfo(uid);

        model.addAttribute("user", user);
        model.addAttribute("userInfo", userInfo);
        return "home";
    }


//     @RequestMapping("shoppingCar")
//     public String shoppingCar() {
//
//         // Integer uid = ((User) session.getAttribute("userSession")).getUserId();
//
//         UserOrderExample example = new UserOrderExample();
//         // example.createCriteria().andOrderStatusEqualTo(0).andOrderUidEqualTo(uid);
//
//         // List<UserOrder> shoppingCar = userOrderService.selectByExampleWithProduct(example);
//         // request.setAttribute("shoppingCar", shoppingCar);
//         return "shoppingCar";
//     }
//
//     @RequestMapping("payment")
//     public String payment(@RequestParam("uoid") String uoid, @RequestParam("totalMoney") String totalMoney,
//                           UserOrder userOrder) {
//         if ("".equals(uoid) || "".equals(totalMoney) || uoid == null || totalMoney == null) {
//             return "redirect:index.jsp";
//         }
//
//         String[] uoids = uoid.split("-");
//         for (String id : uoids) {
//             userOrder.setOrderId(Integer.parseInt(id));
//             Date orderDateTime = new Date(System.currentTimeMillis());
//             userOrder.setOrderDateTime(orderDateTime);
//             // userOrderService.updateOrderByPrimaryKey(userOrder);
//         }
//
//         request.setAttribute("totalMoney", totalMoney);
//         request.setAttribute("uoid", uoid);
//         return "payment";
//     }
//
//
//     @RequestMapping("userOrder")
//     public <T> String userOrderPage(@RequestParam(value = "type", defaultValue = "0") Integer type,
//                                     @RequestParam(value = "keyword", required = false) String keyword, @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
// //		设置分页大小
//         PageHelper.startPage(pn, 5);
//         User user = (User) session.getAttribute("userSession");
//         // Integer uid = user.getUserId();
//
//         UserOrderExample example = new UserOrderExample();
//         com.ou.mall.bean.UserOrderExample.Criteria createCriteria = example.createCriteria();
//         if (type == 0) {
//             createCriteria.andOrderStatusNotEqualTo(-1);
//             createCriteria.andOrderStatusNotEqualTo(0);
//         } else {
//             createCriteria.andOrderStatusEqualTo(type);
//         }
//         if (keyword != null && !"".equals(keyword)) {
//             createCriteria.andProductTitleLike(keyword);
//         }
        // createCriteria.andOrderUidEqualTo(uid);
        // List<UserOrder> selectByExampleWithProduct = userOrderService.selectByExampleWithProduct(example);
        // PageInfo<UserOrder> pageInfo = new PageInfo<UserOrder>(selectByExampleWithProduct, 5);
        // request.setAttribute("pages", pageInfo);
        // return "userOrder";
    // }



}
