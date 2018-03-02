package com.ou.mall.controller;

import com.github.pagehelper.PageInfo;
import com.ou.mall.bean.Product;
import com.ou.mall.service.ProductService;
import com.ou.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

    @Value("${navigatePages.size}")
    Integer navigatePagesSize;

    /**
     * 主页商品信息
     *
     * @param keyword
     * @param pn
     * @return
     */
    @RequestMapping("index")
    public String index(Model model,
            @RequestParam(defaultValue = "") String keyword
            , @RequestParam(defaultValue = "1") Integer pn) {
        List<Product> all = productService.listIndexProduct(pn, keyword);
        // 分页条最多有5个
        System.out.println(all);
        PageInfo<Product> page = new PageInfo<>(all, navigatePagesSize);
        model.addAttribute("pages", page);
        return "index";
    }


//     @ResponseBody
//     @RequestMapping(value = "login")
//     public Msg login(@Valid User user, BindingResult result) {
//         System.out.println(user);
//         if (result.hasErrors()) {
//             return Msg.failure("").add("msg", "账号或密码错误");
//         }
//         user = userService.login(user);
//         session.setAttribute("userSession", user);
//         if (user == null) {
//             return Msg.failure("").add("msg", "账号或密码错误");
//         }
//         return Msg.success();
//     }
//
//
//     @RequestMapping(value = "logOut")
//     public String logOut() {
//         session.removeAttribute("userSession");
//         return "redirect:login.jsp";
//     }
//
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

    @RequestMapping("home")
    public String home() {
        return "home";
    }


}
