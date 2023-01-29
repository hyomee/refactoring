package com.hyomee.refactoring.initData.policy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DevContractPolicy {

    CONTRACT_POLICY("CONTRACT_POLICY", "무약정", 0),
    CONTRACT_POLICY_12("CONTRACT_POLICY_12", "1년약정", 100000),
    CONTRACT_POLICY_24("CONTRACT_POLICY_24", "2년약정", 200000),
    CONTRACT_POLICY_36("CONTRACT_POLICY_36", "3년약정", 300000);

    // 약정 할인 ( 기본 정책 : 0, 12개월 : -100,000, 24개월 : -200,000 , 36 개월 : -300,000 )
    private String contractPolicyCd;
    private String contractPolicyNm;
    private double contractPolicyDcPrice;
}
