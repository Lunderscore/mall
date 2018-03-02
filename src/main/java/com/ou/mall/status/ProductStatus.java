package com.ou.mall.status;

/**
 * @author: kpkym
 * date: 2018/3/2
 * time: 13:50
 */
public enum ProductStatus {
    del(new Byte("-1")), sale(new Byte("0")), withdraw(new Byte("1"));

    private final byte i;

    private ProductStatus(byte i) {
        this.i = i;
    }

    public byte getValue() {
        return this.i;
    }
}
