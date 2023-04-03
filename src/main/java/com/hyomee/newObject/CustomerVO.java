package com.hyomee.newObject;

public class CustomerVO {
    private String customerNo;
    private String name;
    private String customerId;

    private String age;

    public CustomerVO(String customerNo, String name, String customerId, String age) {
        this.customerNo = customerNo;
        this.name = name;
        this.customerId = customerId;
        this.age = age;
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
