package com.hyomee.newObject.builder.lombok;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerVOTest {

    @Test
    void builder() {
        CustomerVO customerVO = CustomerVO.builder()
                .id(UUID.randomUUID().variant())
                .name("롬북")
                .build();

        System.out.println(customerVO.toString());
    }
}