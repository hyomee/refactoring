package com.hyomee.newObject.builder.gof.ott.service;

import com.google.gson.Gson;

import java.util.List;

public abstract class OttIService {
    public <T> String getOttTransData(SubscriberVO subscriberVO,
                                  List<ProductVO> productVOs) {
        T t = createOttService(subscriberVO, productVOs);
        return convertMsg(t);
    }
    abstract <T> T  createOttService(SubscriberVO subscriberVO, List<ProductVO> productVOs);

    public <T> String convertMsg(T t) {
        return  new Gson().toJson(t);
    }
}
