package com.hyomee.example35.e01.event.vo;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Builder
public class SaleEventVO {

    private String subscriberid;

    private String modelNo;
    private int devicePrice;
    private boolean eventCandiDateSubmit;

    private String productCode;

}
