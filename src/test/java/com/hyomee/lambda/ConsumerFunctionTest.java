package com.hyomee.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConsumerFunctionTest {

    @Autowired
    ConsumerFunction consumerFunction;

    private 상품VO 상품vo;
    private 상품VO 기대상품vo;
    @BeforeEach
    void setUp() {
        상품vo = 상품VO.builder()
                .가입자ID("10001")
                .요금상품금액(20000.0)
                .build();

        기대상품vo = 상품VO.builder()
                .가입자ID("10001")
                .요금상품금액(19000.0)
                .build();
    }
    @Test
    void 상품금액기본할인요율적용() {

        consumerFunction.상품금액기본할인요율적용(상품vo);
        assertThat(기대상품vo).usingRecursiveComparison().isEqualTo(상품vo);
    }
}