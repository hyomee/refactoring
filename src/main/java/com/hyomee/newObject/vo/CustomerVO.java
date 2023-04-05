package com.hyomee.newObject.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerVO {
    private String customerNo;
    private String name;
    private String customerId;

    private String age;

    public CustomerVO(String name, String customerId ) {
        this("", name, customerId, calAge(customerId));
    }

    public CustomerVO(String customerNo, String name, String customerId, String age) {
        this.customerNo = customerNo;
        this.name = name;
        this.customerId = customerId;
        this.age = age;
    }

    private static String calAge(String customerId) {
        return String.valueOf(Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy")))
                - Integer.parseInt(customerId.substring(0,4)));
    }

    public CustomerVO(YoungCustomerVO youngCustomerVO) {
        this(youngCustomerVO.getCustomerNo(),
             youngCustomerVO.getName(),
             youngCustomerVO.getCustomerId(),
             youngCustomerVO.getAge());
    }

    public static CustomerVO newYoungCustomerVO(YoungCustomerVO youngCustomerVO) {
        return new CustomerVO(youngCustomerVO.getCustomerNo(),
                youngCustomerVO.getName(),
                youngCustomerVO.getCustomerId(),
                youngCustomerVO.getAge());
    }


    @Override
    public String toString() {
        return "CustomerVO{" +
                "customerNo='" + customerNo + '\'' +
                ", name='" + name + '\'' +
                ", customerId='" + customerId + '\'' +
                ", age='" + age + '\'' +
                '}';
    }


}
