package com.hyomee.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 테스트 코드
 */
@SpringBootTest
class ExamplePredicateTest {

    @Autowired
    ExamplePredicate examplePredicate;

    private List<가입자VO> 가입자vos;
    private List<가입자VO> 기대가입자vos;
    @BeforeEach
    void setUp() {
        가입자vos = List.of(
                가입자VO.builder().가입자ID("100001").요금상품금액(30000).build(),
                가입자VO.builder().가입자ID("100002").요금상품금액(60000).build(),
                가입자VO.builder().가입자ID("100003").요금상품금액(61000).build(),
                가입자VO.builder().가입자ID("100004").요금상품금액(50000).build()
        );

        기대가입자vos = List.of(
                가입자VO.builder().가입자ID("100002").요금상품금액(60000).build(),
                가입자VO.builder().가입자ID("100003").요금상품금액(61000).build()
        );

    }
    @Test
    void hdtv추가상품() {

        List<가입자VO> 목적가입자vos = examplePredicate.hdtv추가상품(가입자vos);
        assertThat(기대가입자vos).usingRecursiveComparison().isEqualTo(목적가입자vos);

    }
}