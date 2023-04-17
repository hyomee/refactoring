package com.hyomee.newObject.builder.gof.ott.service;

import com.google.gson.Gson;
import com.hyomee.newObject.builder.gof.ott.requestObject.Director;
import com.hyomee.newObject.builder.gof.ott.requestObject.builder.OttBuilder;
import com.hyomee.newObject.builder.gof.ott.requestObject.builder.tving.TvingBuilder;
import com.hyomee.newObject.builder.gof.ott.requestObject.builder.tving.TvingVO;
import com.hyomee.newObject.builder.gof.ott.requestObject.builder.wave.WaveBuilder;
import com.hyomee.newObject.builder.gof.ott.requestObject.builder.wave.WaveVO;

import java.util.List;

public class WaveSwevice extends OttIService {

    @Override
    <T> T createOttService(SubscriberVO subscriberVO, List<ProductVO> productVOs) {
        OttBuilder waveBuilder = new WaveBuilder();

        waveBuilder.subscriber(subscriberVO)
                .product(productVOs);

        WaveVO waveVO = waveBuilder.build();
        return (T) waveVO;

    }
}
