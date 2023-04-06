package com.hyomee.newObject;

import com.hyomee.newObject.builder.base.SubscriberBuilder;
import com.hyomee.newObject.builder.base.SubscriberInnerBuilderVO;
import com.hyomee.newObject.builder.base.SubscriberVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SubscriberBuilderTest {

    @Test
    @DisplayName("빌더 패턴")
    void SubscriberBuilder() {
        SubscriberBuilder subscriberBuilder = new SubscriberBuilder();
        SubscriberVO subscriberVO= subscriberBuilder
                .subscriberNo("1000000")
                .agencyCd("10000")
                .model("AS300")
                .phoneNumber("01093223456")
                .build();

        System.out.println(subscriberVO.toString());
    }
    @Test
    @DisplayName("빌더 inner 패턴")
    void SubscriberInnerBuilderVO() {

        SubscriberInnerBuilderVO subscriberInnerBuilderVO =
                SubscriberInnerBuilderVO.builder("1000000", "10000", "AS300", "01093223456");

        System.out.println(subscriberInnerBuilderVO.toString());
    }

    @Test
    @DisplayName("빌더 inner 패턴")
    void SubscriberInnerBuilderVO_01() {

        SubscriberInnerBuilderVO subscriberInnerBuilderVO =
                SubscriberInnerBuilderVO.builder01()
                        .subscriberNo("1000000")
                        .agencyCd("1000")
                        .model("sm003")
                        .phoneNumber("01009411232")
                        .build();


        System.out.println(subscriberInnerBuilderVO.toString());
    }
}
