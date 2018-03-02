package com.ou.mall.bean;

import com.ou.mall.validation.AddProduct;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

public class Product {
    @Null(groups = AddProduct.class)
    private Integer id;
    @NotBlank(groups = AddProduct.class)
    private String title;
    @NotBlank(groups = AddProduct.class)
    private String info;
    @DecimalMin(value = "0.01", groups = AddProduct.class)
    private BigDecimal price;
    @Min(value = 1, groups = AddProduct.class)
    private Integer stock;
    @Null(groups = AddProduct.class)
    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", info=").append(info);
        sb.append(", price=").append(price);
        sb.append(", stock=").append(stock);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}