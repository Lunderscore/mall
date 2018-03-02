package com.ou.mall.bean;

import java.math.BigDecimal;

public class Product {
    public static final Integer STATUS_DELETE = -1;
    public static final Integer STATUS_NORMAL = 0;
    public static final Integer STATUS_WITHDRAW = 1;

    private Integer productId;

    private String productTitle;

    private String productInfo;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productImg1;

    private String productImg2;

    private String productImg3;

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
}