package com.hyomee.newObject.builder.gof;

import com.hyomee.newObject.builder.gof.builder.AppleBuilder;
import com.hyomee.newObject.builder.gof.builder.DeviceVO;
import com.hyomee.newObject.builder.gof.builder.SamsungBuilder;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class DirectorTest {

    Director director = new Director();

    @Test
    void gofBuilerTest() {
        DeviceVO samsung = samsung();
        DeviceVO apple = apple();
        System.out.println(samsung.toString());
        System.out.println(apple.toString());
    }

    DeviceVO samsung() {
        SamsungBuilder samsungBuilder = new SamsungBuilder();
        director.samsung(samsungBuilder);
        samsungBuilder.id(UUID.randomUUID().toString());
        samsungBuilder.color("흰색");
        samsungBuilder.serialNo("SM-0001-0000");
        return samsungBuilder.build();
    }


    DeviceVO apple() {
        AppleBuilder appleBuilder = new AppleBuilder();
        director.apple(appleBuilder);
        appleBuilder.id(UUID.randomUUID().toString());
        appleBuilder.color("검정");
        appleBuilder.serialNo("APPLE-0001-0000");
        return appleBuilder.build();


    }
}