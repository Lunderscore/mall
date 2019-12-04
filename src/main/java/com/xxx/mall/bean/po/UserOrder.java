package com.xxx.mall.bean.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserOrder {
    private Integer orderId;

    private Integer orderNumber;

    private Integer orderStatus;

    private Date orderDateTime;

    private Integer orderPid;

    private Integer orderUid;

    private String orderPersonName;

    private String orderPhone;

    private String orderAddress;

    private String orderMessage;

    private Product product;
}