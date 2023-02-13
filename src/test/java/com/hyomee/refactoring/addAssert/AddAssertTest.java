package com.hyomee.refactoring.addAssert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddAssertTest {

    @Autowired
    AddAssert addAssert;

    고객정보VO a고객정보VO;

    @BeforeEach
    void setUp() {
        a고객정보VO = 고객정보VO.builder()
                .고객번호("100000")
                .build();
    }

    @Test
    void 요금계산_Test() throws Exception {
        addAssert.요금계산(a고객정보VO);
    }

    @Test
    void asserT요금계산_Test() {
        int result = addAssert.asserT요금계산(a고객정보VO);
        assertEquals(1000, result);
    }
}