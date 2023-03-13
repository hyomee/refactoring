package com.hyomee.example35.e01.event;

import com.hyomee.example35.e01.event.vo.BenefitVO;
import com.hyomee.example35.e01.event.vo.SaleEventVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class EventSoC35Test {



    @Autowired
    private EventSoC35 eventSoC35;

    private SaleEventVO saleEventVO;
    @BeforeEach
    void setUp() {
        saleEventVO = SaleEventVO.builder()
                .subscriberid("S0000001")
                .modelNo("Galaxy_02")
                .devicePrice(1000000)
                .eventCandiDateSubmit(true)
                .productCode("PROD_0004")
                .build();
    }
    @Test
    void wirelessSubscriberEvent() {
        BenefitVO benefitVO = eventSoC35.wirelessSubscriberEvent(saleEventVO);
        log.debug(benefitVO.toString());
        assertEquals("", benefitVO.getReason());
    }
}