package com.ou.mall.bean;

import com.ou.mall.validation.AddProduct;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

public class Product {
    public static final Integer STATUS_DELETE = -1;
    public static final Integer STATUS_NORMAL = 0;
    public static final Integer STATUS_WITHDRAW = 1;

    @Null(groups = AddProduct.class)
    private Integer productId;
    @NotBlank(groups = AddProduct.class)
    private String productTitle;
    @NotBlank(groups = AddProduct.class)
    private String productInfo;
    @DecimalMin(value = "0.01", groups = AddProduct.class)
    private BigDecimal productPrice;
    @Min(value = 1, groups = AddProduct.class)
    private Integer productStock;

    private String productImg1;

    private String productImg2;

    private String productImg3;
    @Null(groups = AddProduct.class)
    private Integer productStatus;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle == null ? null : productTitle.trim();
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo == null ? null : productInfo.trim();
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductImg1() {
        return productImg1;
    }

    public void setProductImg1(String productImg1) {
        this.productImg1 = productImg1 == null ? null : productImg1.trim();
    }

    public String getProductImg2() {
        return productImg2;
    }

    public void setProductImg2(String productImg2) {
        this.productImg2 = productImg2 == null ? null : productImg2.trim();
    }

    public String getProductImg3() {
        return productImg3;
    }

    public void setProductImg3(String productImg3) {
        this.productImg3 = productImg3 == null ? null : productImg3.trim();
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", productInfo='" + productInfo + '\'' +
                ", productPrice=" + productPrice +
                ", productStock=" + productStock +
                ", productImg1='" + productImg1 + '\'' +
                ", productImg2='" + productImg2 + '\'' +
                ", productImg3='" + productImg3 + '\'' +
                ", productStatus=" + productStatus +
                '}';
    }
}