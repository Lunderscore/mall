package com.xxx.mall.bean.po;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAddress {
    private Integer addressId;

    private String addressName;

    private String addressPhone;

    private String addressContent;

    private Integer addressUid;
}