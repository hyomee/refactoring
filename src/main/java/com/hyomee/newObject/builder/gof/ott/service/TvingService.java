package com.hyomee.newObject.builder.gof.ott.service;

import com.hyomee.newObject.builder.gof.ott.requestObject.builder.OttBuilder;
import com.hyomee.newObject.builder.gof.ott.requestObject.builder.tving.TvingBuilder;
import com.hyomee.newObject.builder.gof.ott.requestObject.builder.tving.TvingVO;

import java.util.List;

public class TvingService extends OttIService {

    @Override
    <T> T  createOttService(SubscriberVO subscriberVO, List<ProductVO> productVOs) {
        OttBuilder tvingBuilder =  new TvingBuilder();

        tvingBuilder.subscriber(subscriberVO)
                .product(productVOs);

        TvingVO tvingVO = tvingBuilder.build();
        return (T) tvingVO;
    }
}
