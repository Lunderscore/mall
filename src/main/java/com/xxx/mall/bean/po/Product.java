package com.xxx.mall.bean.po;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private Integer productId;

    private String productTitle;

    private String productInfo;

    private Double productPrice;

    private Integer productStock;

    private String productImg1;

    private String productImg2;

    private String productImg3;

    private Integer productStatus;
}