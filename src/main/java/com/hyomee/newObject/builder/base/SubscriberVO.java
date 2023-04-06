package com.hyomee.newObject.builder.base;

public class SubscriberVO {
    private String subscriberNo;
    private String phoneNumber;
    private String model;
    private String agencyCd;

    @Override
    public String toString() {
        return "SubscriberVO{" +
                "subscriberNo='" + subscriberNo + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", model='" + model + '\'' +
                ", agencyCd='" + agencyCd + '\'' +
                '}';
    }

    public SubscriberVO(String subscriberNo, String phoneNumber, String model, String agencyCd) {
        this.subscriberNo = subscriberNo;
        this.phoneNumber = phoneNumber;
        this.model = model;
        this.agencyCd = agencyCd;
    }





}
