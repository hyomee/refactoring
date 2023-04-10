package com.hyomee.newObject.builder.gof.ott.requestObject.builder.wave;

import java.util.List;

public class WaveVO {

    private String transectionId;
    private String subscriberId;
    private String phoneNumber;
    private String status;

    private String startDate;
    private String endData;

    List<WaveProdVO> waveProdVOList;

     WaveVO(String transectionId,
                  String subscriberId,
                  String phoneNumber,
                  String status,
                  String startDate,
                  String endData,
                  List<WaveProdVO> waveProdVOList) {
        this.transectionId = transectionId;
        this.subscriberId = subscriberId;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.startDate = startDate;
        this.endData = endData;
        this.waveProdVOList = waveProdVOList;
    }


}
