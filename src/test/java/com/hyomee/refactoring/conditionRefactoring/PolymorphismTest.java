package com.hyomee.refactoring.conditionRefactoring;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        classes = {Polymorphism.class}
)
class PolymorphismTest {
    private 고객정보VO l고객정보VO;
    private 판매정보VO l판매정보VO;
    @Autowired
    private Polymorphism polymorphism;

    @BeforeEach
    void setUp() {
        l고객정보VO = 고객정보VO.builder()
                .고객번호("A0000001")
                .고객명("홍길동")
                .고객등급("2등급")
                .가입기간(5)
                .신규여부(false)
                .build();

        l판매정보VO = 판매정보VO.builder()
                .고격번호("A0000001")
                .판매금액( 600000.0 )
                .build();
    }

    @Test
    void 고객판매정보_getRate() {


        double 금액 =  polymorphism.getRate( l고객정보VO,  l판매정보VO);

        assertEquals(560000.0, 금액);
    }

    @Test
    void 고객판매정보_getRateRefactoring() {

        double 리펙요금 = polymorphism.getRateRefactoring( l고객정보VO, l판매정보VO);

        assertEquals(560000.0, 리펙요금);
    }
}