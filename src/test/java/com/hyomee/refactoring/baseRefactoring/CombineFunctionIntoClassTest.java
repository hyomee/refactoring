package com.hyomee.refactoring.baseRefactoring;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class CombineFunctionIntoClassTest {

    @Autowired
    private  Client01 client01;

    @Autowired
    private  Client01 client02;

    @Autowired
    private  Client01 client03;

    @Test
    void usePeriod() {
        int value = client01.usePeriod(5, 2019);
        assertEquals(55,value);
    }

    @Test
    void calculationOfPricePlanByClient01() {
        int value = client01.calculationOfPricePlan();
        assertEquals(37500, value);
    }


    @Test
    void calculationOfPricePlanByclient02() {
        int value = client02.calculationOfPricePlan();
        assertEquals(37500, value);
    }

    @Test
    void calculationOfPricePlanByclient03() {
        int value = client03.calculationOfPricePlan();
        assertEquals(37500, value);
    }

    @Test
    void calculationOfPricePlanByClient01Refactoring() {
        int value = client01.calculationOfPricePlan();
        assertEquals(37500, value);
    }


    @Test
    void calculationOfPricePlanByclient02Refactoring() {
        int value = client02.calculationOfPricePlan();
        assertEquals(37500, value);
    }

    @Test
    void calculationOfPricePlanByclient03Refactoring() {
        int value = client03.calculationOfPricePlan();
        assertEquals(37500, value);
    }
}