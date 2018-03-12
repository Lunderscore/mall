package com.ou.mall.bean;

import com.ou.mall.validtion.AddUserAddressValidtiom;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

public class UserAddress {
    @Null(groups = AddUserAddressValidtiom.class)
    private Integer id;

    @NotBlank(groups = AddUserAddressValidtiom.class, message = "姓名不能为空")
    private String name;

    @NotBlank(groups = AddUserAddressValidtiom.class, message = "手机号码不能为空")
    @Pattern(regexp = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$",
        groups = AddUserAddressValidtiom.class, message = "请输入正确的手机号码")
    private String phone;

    @NotBlank(groups = AddUserAddressValidtiom.class, message = "留言不能为空")
    private String content;

    @Null(groups = AddUserAddressValidtiom.class)
    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", content=").append(content);
        sb.append(", uid=").append(uid);
        sb.append("]");
        return sb.toString();
    }
}