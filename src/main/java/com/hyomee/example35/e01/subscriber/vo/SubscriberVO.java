package com.hyomee.example35.e01.subscriber.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubscriberVO {
    private String subscriberId;
    private String customerId;
    private String subscriberStatus;
    private String phoneNumber;

}
