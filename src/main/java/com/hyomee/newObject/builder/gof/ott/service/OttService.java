package com.hyomee.newObject.builder.gof.ott.service;

import com.hyomee.newObject.builder.gof.ott.requestObject.Director;


import java.util.List;

public class OttService {

    private final Director director;
    private final List<String> OTT_PROD_TYPE_LIST = List.of("WAVE", "TVING");

    public OttService(Director director) {
        this.director = director;
    }

    public String getTransData(SubscriberVO subscriberVO,
                               List<ProductVO> productVOs) {

        String transData = "";

        String prodType = productVOs.stream()
                .filter(productVO -> OTT_PROD_TYPE_LIST.stream().anyMatch(type -> type.equals(productVO.getProductType())))
                .map(ProductVO::getProductType)
                .findFirst()
                .orElse("");

        if ("WAVE".equals(prodType)) {
            transData = ottWaveMakeMsg(subscriberVO, productVOs);
        } else if ("TVING".equals(prodType)) {
            transData = ottTvingMakeMsg(subscriberVO, productVOs);
        }

        return transData;
    }


    public String ottTvingMakeMsg(SubscriberVO subscriberVO,
                              List<ProductVO> productVOs) {
        // TvingVO tvingVO = new TvingVO();
        return director.makeTvingVO(subscriberVO, productVOs);

    }

    public String ottWaveMakeMsg(SubscriberVO subscriberVO,
                                 List<ProductVO> productVOs) {
        return director.makeWaveVO(subscriberVO, productVOs);

    }


}
