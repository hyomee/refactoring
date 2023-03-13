package com.hyomee.refactoring.ecapsulate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplaceTempWithQueryTest {

    @Autowired
    ReplaceTempWithQuery replaceTempWithQuery;
    @Test
    void 특정단말기부가사품추가() {

        String 상픔 = replaceTempWithQuery.mms지원단말부가상품추가("MDL_0003");
        assertEquals("추가상품", 상픔);
    }
}