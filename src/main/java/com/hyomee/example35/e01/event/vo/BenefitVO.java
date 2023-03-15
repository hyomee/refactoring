package com.hyomee.example35.e01.event.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class BenefitVO {

    private String reason;
    private String productCode;
    private int devicePrice;

    public static BenefitVO initBenefitVO(String reason) {
        return BenefitVO.builder()
                .reason(reason)
                .productCode("")
                .devicePrice(0)
                .build();
    }
}
