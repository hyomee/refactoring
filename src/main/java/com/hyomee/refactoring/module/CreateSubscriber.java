package com.hyomee.refactoring.module;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

public class CreateSubscriber {

    public void newAccount() {
        // 가입 조건 체크
        // - 신용불향자 체크
        // 고객 등록
        // 청구/납부 등록
        // 가입 등록
        // 상품 등록
        // 단말 등록
        // ...
    }


}


@Data
@Builder(toBuilder = true)
class customerVO {
    private String customerId;          // 고객 아이디
    private String customerName;        // 고객 명
    private String age;                 // 나이
    private String customerType;        // 고객유형
}

@Data
@Builder(toBuilder = true)
class subscriberVO {
    private String subscriberId;       // 가입아이디
    private String serviceCode;        // 가입 서비스
    private String phoneNumber;        // 핸드폰 번호
    private String customerId;         // 고객 어이디
    private String sbscriptionStatus;   // 가입상태
}

@Data
@Builder(toBuilder = true)
class subscriberProduct {
    private String subscriberId;        // 가입아이디
    private String subscriberProduct;   // 가입상품
    private String productType;         // 상품구분
    private String productRate;         // 상품금액
    private String productStatus;       // 가입상품상태
}

@Data
@Builder(toBuilder = true)
class subscriberDevice {
    private String subscriberId;        // 가입아이디
    private String model;               // 가입자단말모델
    private String deviceRate;         // 가입자단말금랙
    private String deviceStatus;       // 가입자단말상태
}

@Data
@Builder(toBuilder = true)
class billingAccount {
    private String subscriberId;        // 가입아이디
    private String model;               // 가입자단말모델
    private String deviceRate;         // 가입자단말금랙
    private String deviceStatus;       // 가입자단말상태
}