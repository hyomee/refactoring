package com.hyomee.example35.e01.device.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviceBySubscribeVO {
    private String deviceId;
    private String subscriberId;
    private String modelNo;
    private String modelNm;

    private String deviceStatus;
    private int salePrice;

}
