package com.hyomee.newObject.builder.gof.ott.requestObject.builder.wave;



import com.hyomee.newObject.builder.gof.ott.requestObject.builder.OttBuilder;
import com.hyomee.newObject.builder.gof.ott.service.ProductVO;
import com.hyomee.newObject.builder.gof.ott.service.SubscriberVO;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class WaveBuilder implements OttBuilder {

    String transectionId;
    String subscriberId;
    String phoneNumber;
    String status;
    String startDate;
    String endData;
    List<WaveProdVO> waveProdVOs;

    public WaveBuilder() {
        this.transectionId = "WAVE_" + UUID.randomUUID().toString();
    }

    @Override
    public OttBuilder subscriber(SubscriberVO subscriberVO) {
        this.subscriberId = subscriberVO.getSubscriberId();
        this.phoneNumber = subscriberVO.getPhoneNumber();
        this.status = subscriberVO.getStatus();
        this.startDate = subscriberVO.getStartDate();
        this.endData = subscriberVO.getEndData();
        return this;
    }

    @Override
    public OttBuilder product(List<ProductVO> productVOs) {
        this.waveProdVOs = new LinkedList<>();
        for( ProductVO productVO : productVOs) {
            this.waveProdVOs.add(new WaveProdVO(productVO.getProductId(),
                                            productVO.getProductName(),
                                            productVO.getProductStatus()));
        }

        return this;
    }

    @Override
    public WaveVO build () {
        return new WaveVO(this.transectionId,
                this.subscriberId,
                this.phoneNumber,
                this.status,
                this.startDate,
                this.endData,
                this.waveProdVOs);
    }
}
