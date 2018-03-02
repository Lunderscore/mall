package com.ou.mall.controller;

import com.github.pagehelper.PageInfo;
import com.ou.mall.bean.Msg;
import com.ou.mall.bean.Product;
import com.ou.mall.bean.UploadedImageFile;
import com.ou.mall.service.ProductService;
import com.ou.mall.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 本类负责维护管理员页面
 *
 * @author: kpkym
 * date: 2018/3/1
 * time: 15:40
 */
@RequestMapping("admin")
@Controller
public class AdminController {
    @Autowired
    ProductService productService;

    /**
     * 管理员登录
     *
     * @param username
     * @param password
     * @return 成功 success 失败 failure
     */
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Msg login(String username, String password, HttpSession session) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return Msg.failure("账号密码不能为空");
        }
        if (!"admin".equals(username) || !"admin".equals(password)) {
            return Msg.failure("账号密码错误");
        }
        session.setAttribute("admin", username);
        return Msg.success();
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("admin");
        return "redirect:../login.jsp";
    }


    /**
     * 获取所有商品的信息
     * 显示五个分页
     * 每页有5个商品
     *
     * @param keyword
     * @param pn
     * @return 返回所有status不为-1的商品
     */
    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String listProduct(Model model, @RequestParam(value = "keyword", defaultValue = "") String keyword
            , @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        List<Product> products = productService.listAdminProduct(pn, keyword);
        PageInfo<Product> page = new PageInfo<>(products, 5);
        model.addAttribute("pages", page);
        return "admin/products";
    }


    /**
     * 通过主键获取商品
     *
     * @param pid
     * @return 主键为pid的商品
     */
    @ResponseBody
    @RequestMapping(value = "products/{pid}", method = RequestMethod.GET)
    public Msg getProduct(@PathVariable("pid") Integer pid) {
        Product product = productService.getProduct(pid);
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
    public String updatePicture(HttpSession session, UploadedImageFile image, @PathVariable("pid") Integer pid
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

    @RequestMapping(value = "/products/{pid}", method = RequestMethod.PUT)
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
