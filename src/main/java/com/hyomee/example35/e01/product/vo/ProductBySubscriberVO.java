package com.hyomee.example35.e01.product.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductBySubscriberVO {
    private String productId;
    private String subscriberId;
    private String productCode;
    private String productName;
    private String productType;
    private String productStatus;
}
