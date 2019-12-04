package com.xxx.mall.bean.po;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private Integer userId;

    private String userUsername;

    private String userPassword;

    private String userAvatar;

    private Double userMoney;
}