package com.hyomee.newObject.builder.gof.ott.service;

import com.hyomee.newObject.builder.gof.ott.requestObject.Director;
import com.hyomee.newObject.builder.gof.ott.requestObject.builder.tving.TvingVO;
import com.hyomee.newObject.builder.gof.ott.requestObject.builder.wave.WaveVO;

import java.util.List;

public class OttService {

    private final Director director;

    public OttService(Director director) {
        this.director = director;
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
