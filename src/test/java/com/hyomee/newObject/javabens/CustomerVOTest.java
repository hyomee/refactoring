package com.hyomee.newObject.javabens;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class CustomerVOTest {

    @Test
    @DisplayName("JavaBeans 패턴 - 생성 테스트")
    void createCustomer() {
        CustomerVO customerVO = new CustomerVO();
        customerVO.setCustomerNo("C0001");
        customerVO.setName("홀길동");
        customerVO.setCustomerId("20020523140000");
        customerVO.setAge("21");

        System.out.println(customerVO.toString());
        // 객체 불변성 깨짐
        customerVO.setName("김나리");
        System.out.println(customerVO.toString());
    }

    @Test
    @DisplayName("JavaBeans 패턴 - 생성 테스트- 객체불변성 유지")
    void createCustomer_freezing() {
        CustomerVO customerVO = new CustomerVO();
        customerVO.setCustomerNo("C0001");
        customerVO.setName("홀길동");
        customerVO.setCustomerId("20020523140000");
        customerVO.setAge("21");
        customerVO.freeze();

        System.out.println(customerVO.toString());
        // 객체 불변성 깨짐
        customerVO.setName("김나리");
        System.out.println(customerVO.toString());
    }

}