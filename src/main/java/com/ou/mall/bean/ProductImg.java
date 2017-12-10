package com.ou.mall.bean;

public class ProductImg {
    private Integer imgId;

    private String imgImg2;

    private String imgImg3;

    private Integer imgPid;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgImg2() {
        return imgImg2;
    }

    public void setImgImg2(String imgImg2) {
        this.imgImg2 = imgImg2 == null ? null : imgImg2.trim();
    }

    public String getImgImg3() {
        return imgImg3;
    }

    public void setImgImg3(String imgImg3) {
        this.imgImg3 = imgImg3 == null ? null : imgImg3.trim();
    }

    public Integer getImgPid() {
        return imgPid;
    }

    public void setImgPid(Integer imgPid) {
        this.imgPid = imgPid;
    }
}