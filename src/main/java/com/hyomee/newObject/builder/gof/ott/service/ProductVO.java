package com.hyomee.newObject.builder.gof.ott.service;

public class ProductVO {


    private String productId;
    private String productName;
    private String productStatus;
    private String productType;

    public ProductVO(String productId,
                     String productName,
                     String productStatus,
                     String productType) {

        this.productId = productId;
        this.productName = productName;
        this.productStatus = productStatus;
        this.productType = productType;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
    public void setProductType(String productType) { this.productType = productType; }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public String getProductType() { return productType; }


}
