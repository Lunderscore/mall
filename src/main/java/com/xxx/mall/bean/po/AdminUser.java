package com.xxx.mall.bean.po;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminUser {
    private Integer userId;

    private String userUsername;

    private String userPassword;
}