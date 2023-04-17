package com.hyomee.newObject.builder.gof.ott.service;

import java.util.List;

public class OttClent {

    private OttFactory ottFactory;

    public OttClent(OttFactory ottFactory) {
        this.ottFactory = ottFactory;
    }

    public String getOttTransData(SubscriberVO subscriberVO,
                                  List<ProductVO> productVOs) {
        OttIService ottIService = ottFactory.getOttServie(  productVOs);
        String transData = ottIService.getOttTransData(subscriberVO, productVOs);
        return transData;
    }
}
