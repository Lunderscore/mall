package com.xxx.mall.controller;
/*
 * 本类负责维护管理员页面
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxx.mall.bean.Msg;
import com.xxx.mall.bean.UploadedImageFile;
import com.xxx.mall.bean.po.AdminUser;
import com.xxx.mall.bean.po.AdminUserExample;
import com.xxx.mall.bean.po.Product;
import com.xxx.mall.bean.po.ProductExample;
import com.xxx.mall.service.AdminUserService;
import com.xxx.mall.service.ProductService;
import com.xxx.mall.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    ProductService productService;

    @Autowired
    AdminUserService adminUserService;

    @Autowired
    HttpSession session;

    @Autowired
    HttpServletRequest request;

    /*
     * 管理员登录
     */
    @ResponseBody
    @RequestMapping("/adminLogin")
    public Msg adminLogin(AdminUser user) {
        AdminUserExample example = new AdminUserExample();
        AdminUserExample.Criteria createCriteria = example.createCriteria();
        createCriteria.andUserUsernameEqualTo(user.getUserUsername());
        createCriteria.andUserPasswordEqualTo(user.getUserUsername());
        AdminUser adminUser = adminUserService.login(example);

        if (adminUser == null) {
            return Msg.failure();
        }
        session.setAttribute("adminSession", adminUser);
        return Msg.success();
    }

    /*
     * 管理员注销
     */
    @RequestMapping("adminLogOut")
    public String adminLogOut() {
        session.removeAttribute("adminSession");
        return "redirect:" + request.getServletContext().getContextPath() + "/adminLogin";
    }

    /*
     * 获取所有商品的信息
     * 显示五个分页
     * 每页有5个商品
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts(@RequestParam(value = "keyword", required = false) String keyword
            , @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        if (session.getAttribute("adminSession") == null) {
            return "redirect:" + request.getServletContext().getContextPath() + "/adminLogin";
        }

        PageHelper.startPage(pn, 5);
        List<Product> products;
        ProductExample example = new ProductExample();
        ProductExample.Criteria createCriteria = example.createCriteria();
        if (keyword == null || "".equals(keyword)) {
            keyword = null;
        } else {
            createCriteria.andProductTitleLike("%" + keyword + "%");
        }
        createCriteria.andProductStatusNotEqualTo(-1);
        products = productService.selectByExample(example);

        PageInfo<Product> page = new PageInfo<Product>(products, 5);
        request.setAttribute("pages", page);
        return "admin";
    }

    /*
     * 通过主键获取商品
     */
    @ResponseBody
    @RequestMapping(value = "/products/{pid}", method = RequestMethod.GET)
    public Msg getProductByprimaryKey(@PathVariable("pid") Integer pid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andProductIdEqualTo(pid);
        example.createCriteria().andProductStatusNotEqualTo(-1);

        Product product = productService.selectAdminProductByPrimaryKey(example);

        Msg msg = Msg.success();
        msg.add("product", product);
        return msg;
    }

    /*
     * 增加商品
     */
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String addProduct(Product product) {

        productService.addProduct(product);
        return "redirect:products";
    }

    /*
     * 上传图片
     */
    @RequestMapping(value = "/products/{pid}/{which}", method = RequestMethod.POST)
    public String updatePicture(UploadedImageFile image, @PathVariable("pid") Integer pid
            , @PathVariable("which") Integer which) throws Exception {
        String productImgPath = session.getServletContext().getRealPath("/data/img/products/" + which);
        String newImageName = ImageUtil.transfer(image, productImgPath, pid.toString());

        if (newImageName == null) {
            return "redirect:../../products";
        }
        Product product = new Product();
        product.setProductId(pid);
        String uri = "data/img/products/" + which + "/" + newImageName;
        if (which == 1) {
            product.setProductImg1(uri);
        } else if (which == 2) {
            product.setProductImg2(uri);
        } else if (which == 3) {
            product.setProductImg3(uri);
        }

        productService.updateByPrimaryKeySelective(product);
        return "redirect:../../products";
    }

    /*
     * 更新产品
     */

    @RequestMapping(value = "/products/{pid}", method = RequestMethod.POST)
    public String updateProduct(Product product, @PathVariable("pid") Integer pid) {
        product.setProductId(pid);
        productService.updateByPrimaryKeySelective(product);

        return "redirect:../products";
    }

    @ResponseBody
    @RequestMapping("changeProductStatus")
    public Msg changeProductStatus(@RequestParam("pid") Integer pid, @RequestParam("status") Integer status) {
        Product product = new Product();
        product.setProductId(pid);
        product.setProductStatus(status);

        productService.updateByPrimaryKeySelective(product);
        return Msg.success();
    }
}
