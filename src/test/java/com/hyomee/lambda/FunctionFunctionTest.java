package com.hyomee.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class FunctionFunctionTest {

    @Autowired
    private FunctionFunction functionFunction;

    private List<가입상품VO> 가입자상품VOs;

    @BeforeEach
    void setUp() {
        가입자상품VOs = List.of(가입상품VO.builder().상품코드("SVC_001").상품명("라면").상품가격(500).build(),
                가입상품VO.builder().상품코드("SVC_002").상품명("사과").상품가격(10000).build(),
                가입상품VO.builder().상품코드("SVC_003").상품명("배").상품가격(12000).build());
    }

    @Test
    void FunctionFunction_TEST() {
        Double 가입상품가격s = functionFunction.가입자상품가격(가입자상품VOs);
        assertEquals(22500, 가입상품가격s);
    }
}