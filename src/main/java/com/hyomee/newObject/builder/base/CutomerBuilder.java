package com.hyomee.newObject.builder.base;

public class CutomerBuilder {
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

    public CutomerBuilder id(int id) {
        this.id = id;
        return this;
    }

    public CutomerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CutomerBuilder age(String age) {
        this.age = age;
        return this;
    }

    public CutomerBuilder division(String division) {
        this.division = division;
        return this;
    }

    public CutomerBuilder category(String category) {
        this.category = category;
        return this;
    }

    public CutomerBuilder identificationNo(String identificationNo) {
        this.identificationNo = identificationNo;
        return this;
    }

    public CutomerBuilder businessNo(String businessNo) {
        this.businessNo = businessNo;
        return this;
    }

    public CutomerBuilder sex(String sex) {
        this.sex = sex;
        return this;
    }

    public CutomerBuilder zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public CutomerBuilder address(String address) {
        this.address = address;
        return this;
    }

    public CutomerBuilder subAddress(String subAddress) {
        this.subAddress = subAddress;
        return this;
    }

    public CustomerVO build() {
        return new CustomerVO( this.id,
                this.name,
                this.age,
                this.division,
                this.category,
                this.identificationNo,
                this.businessNo,
                this.sex,
                this.zipCode,
                this.address,
                this.subAddress);
    }

}
