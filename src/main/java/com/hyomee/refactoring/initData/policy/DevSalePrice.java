package com.hyomee.refactoring.initData.policy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DevSalePrice {

    ANDRIOD_0001("ANDRIOD_0001", 1200000),
    ANDRIOD_0002("ANDRIOD_0002", 900000),
    APPLE_0001("APPLE_0001", 1500000),
    APPLE_0002("APPLE_0002", 800000);

    private String mdlCd;
    private double price;
}
