package com.hyomee.newObject.builder.base;

public class SubscriberInnerBuilderVO {
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

    public static SubscriberInnerBuilderVO builder(String subscriberNo, String phoneNumber, String model, String agencyCd) {
        return new SubscriberInnerBuilderVO.SubscriberInnerBuiler().subscriberNo(subscriberNo)
                .agencyCd(phoneNumber)
                .model(model)
                .phoneNumber(agencyCd)
                .build();
    }

    public static SubscriberInnerBuiler builder01() {
        return new SubscriberInnerBuiler();
    }
    private SubscriberInnerBuilderVO(SubscriberInnerBuiler subscriberInnerBuiler) {
        this.subscriberNo = subscriberInnerBuiler.subscriberNo;
        this.phoneNumber = subscriberInnerBuiler.phoneNumber;
        this.model = subscriberInnerBuiler.model;
        this.agencyCd = subscriberInnerBuiler.agencyCd;
    }



    public static class SubscriberInnerBuiler  {
        private String subscriberNo;
        private String phoneNumber;
        private String model;
        private String agencyCd;


        public SubscriberInnerBuiler subscriberNo(String subscriberNo) {
            this.subscriberNo = subscriberNo;
            return this;
        }

        public SubscriberInnerBuiler phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public SubscriberInnerBuiler model(String model) {
            this.model = model;
            return this;
        }

        public SubscriberInnerBuiler agencyCd(String agencyCd) {
            this.agencyCd = agencyCd;
            return this;
        }

        public SubscriberInnerBuilderVO build () {
            return new SubscriberInnerBuilderVO(this);
        }
    }

}
