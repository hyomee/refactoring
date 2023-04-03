package com.hyomee.newObject;

import io.micrometer.observation.Observation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CustomerVOTest {

    @Test
    void customerVO() {
        CustomerVO customerVO = new CustomerVO("C10000",
                "홍길동",
                "8901231029318",
                "34");

        System.out.println(customerVO.toString());
    }

    @Test
    @DisplayName("청소년 객체를 받아서 고객 객체 생성 ")
    void youngCustomerVOToCustomerVO() {
        YoungCustomerVO youngCustomerVO = new YoungCustomerVO("C10000",
                "홍길동",
                "8901231029318",
                "34");

        CustomerVO customerVO = new CustomerVO(youngCustomerVO.getCustomerNo(),
                youngCustomerVO.getName(),
                youngCustomerVO.getCustomerId(),
                youngCustomerVO.getAge());

        System.out.println(customerVO.toString());
    }


    @Test
    @DisplayName("주/부생성자 ")
    void primarySecondaryCustomerVO() {
        YoungCustomerVO youngCustomerVO = new YoungCustomerVO("C10000",
                "홍길동",
                "8901231029318",
                "34");

        CustomerVO customerVO = new CustomerVO(youngCustomerVO);

        System.out.println(customerVO.toString());
    }

    @Test
    @DisplayName("정적 메서드")
    void staticCustomerVO() {
        YoungCustomerVO youngCustomerVO = new YoungCustomerVO("C10000",
                "홍길동",
                "8901231029318",
                "34");

        CustomerVO customerVO = CustomerVO.newYoungCustomerVO(youngCustomerVO);

        System.out.println(customerVO.toString());
    }

}