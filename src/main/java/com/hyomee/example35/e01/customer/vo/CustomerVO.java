package com.hyomee.example35.e01.customer.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerVO {
    private String customerId;
    private String customerName;
}
