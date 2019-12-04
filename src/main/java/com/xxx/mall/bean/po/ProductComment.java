package com.xxx.mall.bean.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = { "handler" })
public class ProductComment {
    private Integer commentId;

    private String commentContent;

    private Date commentDateTime;

    private Integer commentUid;

    private Integer commentPid;

    private User user;
}