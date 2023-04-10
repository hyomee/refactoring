package com.hyomee.newObject.builder.gof.ott.requestObject.builder.tving;

public class TvingProdVO {


    private String productId;
    private String productStatus;

    TvingProdVO(String productId, String productStatus) {
        this.productId = productId;
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return "TvingProdVO{" +
                "productId='" + productId + '\'' +
                ", productStatus='" + productStatus + '\'' +
                '}';
    }


}
