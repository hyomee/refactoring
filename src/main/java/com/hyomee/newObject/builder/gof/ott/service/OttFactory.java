package com.hyomee.newObject.builder.gof.ott.service;

import com.hyomee.newObject.builder.gof.ott.requestObject.Director;

import java.util.List;

public class OttFactory {
    private final List<String> OTT_PROD_TYPE_LIST = List.of("WAVE", "TVING");

    public OttIService getOttServie(List<ProductVO> productVOs) {
        OttIService ottIService = null;

        String prodType = productVOs.stream()
                .filter(productVO -> OTT_PROD_TYPE_LIST.stream().anyMatch(type -> type.equals(productVO.getProductType())))
                .map(ProductVO::getProductType)
                .findFirst()
                .orElse("");

        if ("WAVE".equals(prodType)) {
            ottIService =  new WaveSwevice();
        } else if ("TVING".equals(prodType)) {
            ottIService =  new TvingService();
        }

        return ottIService;
    }

}
