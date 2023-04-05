package com.hyomee.newObject.builder;

public class SubscriberBuilder {

    private String subscriberNo;
    private String phoneNumber;
    private String model;
    private String agencyCd;

    public SubscriberBuilder subscriberNo(String subscriberNo) {
        this.subscriberNo = subscriberNo;
        return this;
    }

    public SubscriberBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public SubscriberBuilder model(String model) {
        this.model = model;
        return this;
    }

    public SubscriberBuilder agencyCd(String agencyCd) {
        this.agencyCd = agencyCd;
        return this;
    }

    public SubscriberVO build () {
        return new SubscriberVO(subscriberNo, phoneNumber, model, agencyCd);
    }
}
