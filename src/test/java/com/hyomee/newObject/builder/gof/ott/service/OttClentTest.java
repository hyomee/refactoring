package com.hyomee.newObject.builder.gof.ott.service;

import com.hyomee.newObject.builder.gof.ott.requestObject.Director;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OttClentTest {


    private OttClent ottClent;
    private SubscriberVO subscriberVO = new SubscriberVO() ;
    private List<ProductVO> productVOs = new LinkedList<>();

    @BeforeEach
    void setUp() {
        ottClent = new OttClent(new OttFactory()) ;
        subscriberVO.setSubscriberId("SUB_00001");
        subscriberVO.setPhoneNumber("010092349034") ;
        subscriberVO.setStatus("A");
        subscriberVO.setStartDate("20230409123020") ;
        subscriberVO.setEndData("99991231235959") ;

        productVOs = List.of(
                new ProductVO("PROD_00001", "영상", "A", "UFLIX"),
                new ProductVO("PROD_00002", "영상_002", "A", "WAVE")
        ) ;
    }


    @Test
    void getOttTransData() {
        String transData = ottClent.getOttTransData(subscriberVO, productVOs );
        System.out.println(transData);
    }
}