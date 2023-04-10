package com.hyomee.newObject.builder.gof.ott.requestObject.builder.wave;

public class WaveProdVO {
    private String productId;
    private String productName;

    private String productStatus;

    WaveProdVO(String productId, String productName, String productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productStatus = productStatus;
    }


}
