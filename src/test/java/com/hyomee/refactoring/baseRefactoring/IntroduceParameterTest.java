package com.hyomee.refactoring.baseRefactoring;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class IntroduceParameterTest {

    private TemperatureVO TemperatureVO;

    @Autowired
    IntroduceParameter IntroduceParameter;

    @BeforeEach
    void setTemperatureVO() {
        TemperatureVO = TemperatureVO.builder()
                .min(23)
                .max(43)
                .build();
    }

    @Test
    void introduceParameter() {
        IntroduceParameter.IntroduceParameter(TemperatureVO);
    }
}