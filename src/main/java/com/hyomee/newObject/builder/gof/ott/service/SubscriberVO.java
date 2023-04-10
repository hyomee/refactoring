package com.hyomee.newObject.builder.gof.ott.service;

public class SubscriberVO {


    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndData(String endData) {
        this.endData = endData;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndData() {
        return endData;
    }


    private String subscriberId;
    private String phoneNumber;
    private String status;

    private String startDate;
    private String endData;


}
