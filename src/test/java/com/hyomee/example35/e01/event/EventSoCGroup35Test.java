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
class EventSoCGroup35Test {


    @Autowired
    private EventSoCGroup35 eventSoCGroup35;

    private SaleEventVO saleEventVO;
    @BeforeEach
    void setUp() {
        saleEventVO = SaleEventVO.builder()
                .subscriberid("S0000001")
                .modelNo("Galaxy_01")
                .devicePrice(1000000)
                .eventCandiDateSubmit(true)
                .productCode("PROD_0004")
                .build();
    }
    @Test
    void wirelessSubscriberEvent() {
        BenefitVO benefitVO = eventSoCGroup35.wirelessSubscriberEvent(saleEventVO);
        log.debug(benefitVO.toString());
        assertEquals("", benefitVO.getReason());

        saleEventVO = SaleEventVO.builder()
                .subscriberid("S0000002")
                .modelNo("Galaxy_01")
                .devicePrice(900000)
                .eventCandiDateSubmit(true)
                .productCode("PROD_0004")
                .build();

        benefitVO = eventSoCGroup35.wirelessSubscriberEvent(saleEventVO);
        log.debug(benefitVO.toString());
        assertEquals("", benefitVO.getReason());
    }
}