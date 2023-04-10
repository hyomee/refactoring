package com.hyomee.newObject.builder.gof.ott.requestObject.builder.tving;

import java.util.List;

public class TvingVO {

    private String transectionId;
    private String subscriberId;
    private String phoneNumber;
    private String status;

    List<TvingProdVO> waveProdVOList;

     TvingVO(String transectionId,
             String subscriberId,
             String phoneNumber,
             String status,
             List<TvingProdVO> waveProdVOList) {
        this.transectionId = transectionId;
        this.subscriberId = subscriberId;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.waveProdVOList = waveProdVOList;
    }

    @Override
    public String toString() {
        return "transectionId='" + transectionId + '\'' +
                ", subscriberId='" + subscriberId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status='" + status + '\'' +
                ", waveProdVOList=" + waveProdVOList ;
    }
}
