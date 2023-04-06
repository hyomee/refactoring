package com.hyomee.newObject.builder.base.staticBuilder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerVOTest {

    @Test
    @DisplayName("정적 이너 클래스를 이용한 빌더")
    void staticBuilder() {
        CustomerVO customerV0 = new CustomerVO.Builder(UUID.randomUUID().variant(),"홍길동")
                .division("개인")
                .age("23")
                .build();

        System.out.println(customerV0.toString());
    }
}