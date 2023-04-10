package com.hyomee.newObject.builder.lombok;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class CustomerVO {
    private int id;
    private String name;
    private String age;
    private String division;
    private String category;
    private String identificationNo;
    private String businessNo;
    private String sex;
    private String zipCode;
    private String address;
    private String subAddress;
}
