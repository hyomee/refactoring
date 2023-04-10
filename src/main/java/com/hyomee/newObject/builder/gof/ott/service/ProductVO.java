package com.hyomee.newObject.builder.gof.ott.service;

public class ProductVO {
    public ProductVO(String productId, String productName, String productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productStatus = productStatus;
    }

    private String productId;
    private String productName;
    private String productStatus;

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductStatus() {
        return productStatus;
    }
}
