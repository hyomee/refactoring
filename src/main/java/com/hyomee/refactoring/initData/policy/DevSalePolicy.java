package com.hyomee.refactoring.initData.policy;

import lombok.Getter;

@Getter
public enum DevSalePolicy {
    // ( 기본 정책 : 0, 픅판 1 정책 : -100,000, 픅판 2 정책 : -200,000 )
    BASE_POLICY("BASE_POLICY", "기본정책", 0),
    BASE_POLICY_1("BASE_POLICY_1", "픅판 1 정책 ", 100000),
    BASE_POLICY_2("BASE_POLICY_2", "픅판 2 정책 ", 200000);

    private String salePolicyCd;
    private String salePolicyNm;
    private double salePolicyDcPrice;


    DevSalePolicy(String salePolicyCd, String salePolicyNm, double salePolicyDcPrice) {
        this.salePolicyCd = salePolicyCd;
        this.salePolicyNm = salePolicyNm;
        this.salePolicyDcPrice = salePolicyDcPrice;
    }
}
