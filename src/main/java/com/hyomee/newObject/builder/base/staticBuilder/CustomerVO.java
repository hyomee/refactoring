package com.hyomee.newObject.builder.base.staticBuilder;

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

    public CustomerVO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.division = builder.division;
        this.category = builder.category;
        this.identificationNo = builder.identificationNo;
        this.businessNo = builder.businessNo;
        this.sex = builder.sex;
        this.zipCode = builder.zipCode;
        this.address = builder.address;
        this.subAddress = builder.subAddress;
    }

    public static class Builder {
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

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }


        public Builder age(String age) {
            if (age == null || age.length() == 0 || Integer.parseInt(age) <= 1) {
                throw new IllegalArgumentException("나이는 0보다 커야 합니다.");
            }
            this.age = age;
            return this;
        }

        public Builder division(String division) {
            this.division = division;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder identificationNo(String identificationNo) {
            this.identificationNo = identificationNo;
            return this;
        }

        public Builder businessNo(String businessNo) {
            this.businessNo = businessNo;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder subAddress(String subAddress) {
            this.subAddress = subAddress;
            return this;
        }

        public  CustomerVO build() {
            return new CustomerVO( this);
        }
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
