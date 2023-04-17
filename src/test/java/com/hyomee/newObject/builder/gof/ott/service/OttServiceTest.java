package com.hyomee.newObject.builder.gof.ott.service;

import com.hyomee.newObject.builder.gof.ott.requestObject.Director;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OttServiceTest {

    private OttService ottService;
    private SubscriberVO subscriberVO  ;
    private List<ProductVO> productVOs  ;
    public OttServiceTest(){
        this.ottService =  new OttService(new Director());
        this.subscriberVO = new SubscriberVO();
    }
    @BeforeEach
    void setUp() {
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
    void ottTvingMakeMsg() {
        String msg = ottService.ottTvingMakeMsg(subscriberVO, productVOs);
        System.out.println(msg);
    }

    @Test
    void ottWaveMakeMsg() {
        String msg = ottService.ottWaveMakeMsg(subscriberVO, productVOs);
        System.out.println(msg);
    }

    @Test
    void getTransData() {
        String msg = ottService.ottWaveMakeMsg(subscriberVO, productVOs);
        System.out.println(msg);
    }
}