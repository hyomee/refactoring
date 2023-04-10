package com.hyomee.newObject.builder.gof.ott.requestObject.builder;


import com.hyomee.newObject.builder.gof.ott.service.ProductVO;
import com.hyomee.newObject.builder.gof.ott.service.SubscriberVO;

import java.util.List;

public interface OttBuilder {

    OttBuilder  subscriber(SubscriberVO subscriberVO);
    OttBuilder product(List<ProductVO> productVOs);
    <T> T build();

}
