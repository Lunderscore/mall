package com.ou.mall.controller;

import com.github.pagehelper.PageInfo;
import com.ou.mall.bean.Msg;
import com.ou.mall.bean.Product;
import com.ou.mall.exception.ErrorImgCountException;
import com.ou.mall.service.ProductImgService;
import com.ou.mall.service.ProductService;
import com.ou.mall.status.ProductStatus;
import com.ou.mall.validation.AddProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
    @Autowired
    ProductImgService productImgService;

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
     * 显示5个分页
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

    /**
     * 增加商品
     *
     * @param product
     * @return 重定向到商品管理首页
     */
    @RequestMapping(value = "products", method = RequestMethod.POST)
    public String addProduct(@Validated(AddProduct.class) Product product, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError error : fieldErrors) {
                // TODO
                System.out.println("错误");
            }
        }
        // 格式化BigDecimal 保留两位小数
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String format = decimalFormat.format(product.getPrice());
        product.setPrice(new BigDecimal(format));
        productService.addProduct(product);
        return "redirect:products";
    }

    /**
     * 更新产品
     *
     * @param product
     * @return 重定向到商品管理首页
     */
    @RequestMapping(value = "products/{pid}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable Integer pid,
                                @Validated(AddProduct.class) Product product, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError error : fieldErrors) {
                // TODO
                System.out.println("错误");
            }
        }
        // 格式化BigDecimal 保留两位小数
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String format = decimalFormat.format(product.getPrice());
        product.setPrice(new BigDecimal(format));
        productService.updateProduct(product, pid);
        return "redirect:../products";
    }

    /**
     * 更新产品状态
     *
     * @param pid 商品id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "products/{pid}", method = RequestMethod.PATCH)
    public Msg delProduct(@PathVariable Integer pid, ProductStatus status) {
        productService.delProduct(pid, status);
        return Msg.success();
    }


    /**
     * 上传商品图片
     * @param image
     * @param pid 商品id
     * @param request
     * @return 重定向至商品管理页面
     * @throws IOException
     */
    @RequestMapping(value = "/products/imgs/{pid}", method = RequestMethod.POST)
    public String updatePicture(MultipartFile[] image, @PathVariable Integer pid, HttpServletRequest request) throws IOException, ErrorImgCountException {
        String realPath = request.getServletContext().getRealPath("products/imgs");
        for (MultipartFile file : image) {
            // 图片不为空时保存图片
            if (StringUtils.isEmpty(file.getOriginalFilename())) {
                continue;
            }
            productImgService.insertProductImg(file, realPath, pid);
        }
        return "redirect:../../products";
    }
}
