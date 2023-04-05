package com.hyomee.newObject.javabens;

import com.hyomee.newObject.vo.YoungCustomerVO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerVO {
    private String customerNo;
    private String name;
    private String customerId;
    private String age;

    // 객체 불변성 유지를 위해  freesing 체크 변수
    private boolean freeze = false;

    // 기본 생성자
    public CustomerVO(){}

    public String getCustomerNo() {
        return customerNo;
    }
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (isFreeze()) throw new AssertionError("[객체 불변성] 객체의 값을 변경 할 수 업습니다.");
        this.name = name;

    }
    public String getCustomerId() {  return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public String getAge() {   return age; }
    public void setAge(String age) {  this.age = age; }

    // 객체 불변성 유지를 위한 freesing 코드
    public boolean isFreeze() { return freeze; }

    public void freeze() {  this.freeze = true; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerVO that = (CustomerVO) o;

        if (!customerNo.equals(that.customerNo)) return false;
        if (!name.equals(that.name)) return false;
        if (!customerId.equals(that.customerId)) return false;
        return age.equals(that.age);
    }

    @Override
    public int hashCode() {
        int result = customerNo.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + customerId.hashCode();
        result = 31 * result + age.hashCode();
        return result;
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
