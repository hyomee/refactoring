package com.hyomee.example35.e01.productPlan;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class ProductPlan {

    // 1. 상품 요금 정책
    @Getter
    @AllArgsConstructor
    public enum PRODUCT_PRICE {
        PROD_0001("PROD_0001", 100000 ),
        PROD_0002("PROD_0002",20000 ),
        PROD_0003("PROD_0003",50000 ),
        PROD_0004("PROD_0004",60000 ),
        PROD_0006("PROD_0006",35000 );

        private String productCode;
        private int productPrice;
    }

}
