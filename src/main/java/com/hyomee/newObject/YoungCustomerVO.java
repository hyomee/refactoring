package com.hyomee.newObject;

public class YoungCustomerVO {
    private String customerNo;
    private String name;
    private String customerId;

    private String age;

    public String getCustomerNo() {
        return customerNo;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAge() {
        return age;
    }

    public YoungCustomerVO(String customerNo, String name, String customerId, String age) {
        this.customerNo = customerNo;
        this.name = name;
        this.customerId = customerId;
        this.age = age;
    }

}
