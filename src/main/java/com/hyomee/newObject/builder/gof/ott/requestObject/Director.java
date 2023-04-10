package com.hyomee.newObject.builder.gof.ott.requestObject;

import com.google.gson.Gson;
import com.hyomee.newObject.builder.gof.ott.requestObject.builder.tving.TvingBuilder;
import com.hyomee.newObject.builder.gof.ott.requestObject.builder.tving.TvingVO;
import com.hyomee.newObject.builder.gof.ott.requestObject.builder.wave.WaveBuilder;
import com.hyomee.newObject.builder.gof.ott.requestObject.builder.wave.WaveVO;
import com.hyomee.newObject.builder.gof.ott.service.ProductVO;
import com.hyomee.newObject.builder.gof.ott.service.SubscriberVO;

import java.util.List;

public class Director {

    public String makeTvingVO(SubscriberVO subscriberVO,
                                  List<ProductVO> productVOs) {
        TvingBuilder tvingBuilder =  new TvingBuilder();

        tvingBuilder.subscriber(subscriberVO)
                    .product(productVOs);

        TvingVO tvingVO = tvingBuilder.build();
        return tvingVO.toString();
    }


    public String makeWaveVO(SubscriberVO subscriberVO,
                              List<ProductVO> productVOs) {
        WaveBuilder waveBuilder = new WaveBuilder();

        waveBuilder.subscriber(subscriberVO)
                .product(productVOs);

        WaveVO waveVO = waveBuilder.build();
        return new Gson().toJson(waveVO);

    }

}
