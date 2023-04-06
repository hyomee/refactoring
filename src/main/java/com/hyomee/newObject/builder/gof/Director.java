package com.hyomee.newObject.builder.gof;

import com.hyomee.newObject.builder.gof.builder.DeviceBuilder;

public class Director {

    public void samsung(DeviceBuilder deviceBuilder) {
        deviceBuilder.id("")
                .brand("삼성")
                .type("핸드폰")
                .model("S32")
                .color("검정")
                .serialNo("000000000000");
    }


    public void apple(DeviceBuilder deviceBuilder) {
        deviceBuilder.id("")
                .brand("애플")
                .type("핸드폰")
                .model("아이폰14")
                .color("흰색")
                .serialNo("000000000000");;
    }
}
