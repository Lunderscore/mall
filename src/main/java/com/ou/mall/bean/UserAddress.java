package com.ou.mall.bean;

public class UserAddress {
    private Integer addressId;

    private String addressName;

    private String addressPhone;

    private String addressContent;

    private Integer addressUid;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone == null ? null : addressPhone.trim();
    }

    public String getAddressContent() {
        return addressContent;
    }

    public void setAddressContent(String addressContent) {
        this.addressContent = addressContent == null ? null : addressContent.trim();
    }

    public Integer getAddressUid() {
        return addressUid;
    }

    public void setAddressUid(Integer addressUid) {
        this.addressUid = addressUid;
    }
}