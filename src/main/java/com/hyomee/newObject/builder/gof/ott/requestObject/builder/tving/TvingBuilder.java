package com.hyomee.newObject.builder.gof.ott.requestObject.builder.tving;



import com.hyomee.newObject.builder.gof.ott.requestObject.builder.OttBuilder;
import com.hyomee.newObject.builder.gof.ott.service.ProductVO;
import com.hyomee.newObject.builder.gof.ott.service.SubscriberVO;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class TvingBuilder implements OttBuilder {

    String transectionId;
    String subscriberId;
    String phoneNumber;
    String status;
    List<TvingProdVO> waveProdVOs;


    public TvingBuilder() {
        this.transectionId = "TVING_" + UUID.randomUUID().toString();
    }

    @Override
    public OttBuilder subscriber(SubscriberVO subscriberVO) {
        this.subscriberId = subscriberVO.getSubscriberId();
        this.phoneNumber = subscriberVO.getPhoneNumber();
        this.status = subscriberVO.getStatus();
        return this;
    }

    @Override
    public OttBuilder product(List<ProductVO> productVOs) {
        this.waveProdVOs = new LinkedList<>();
        for( ProductVO productVO : productVOs) {
            this.waveProdVOs.add(new TvingProdVO(productVO.getProductId(),
                                            productVO.getProductStatus()));
        }

        return this;
    }

    @Override
    public TvingVO build () {
        return new TvingVO(this.transectionId,
                this.subscriberId,
                this.phoneNumber,
                this.status,
                this.waveProdVOs);
    }
}
