package com.hyomee.newObject.builder.base;

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

    public CustomerVO(int id,
                      String name,
                      String age,
                      String division,
                      String category,
                      String identificationNo,
                      String businessNo,
                      String sex,
                      String zipCode,
                      String address,
                      String subAddress) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.division = division;
        this.category = category;
        this.identificationNo = identificationNo;
        this.businessNo = businessNo;
        this.sex = sex;
        this.zipCode = zipCode;
        this.address = address;
        this.subAddress = subAddress;
    }



    @Override
    public String toString() {
        return "CustomerVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", division='" + division + '\'' +
                ", category='" + category + '\'' +
                ", identificationNo='" + identificationNo + '\'' +
                ", businessNo='" + businessNo + '\'' +
                ", sex='" + sex + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", address='" + address + '\'' +
                ", subAddress='" + subAddress + '\'' +
                '}';
    }

}
