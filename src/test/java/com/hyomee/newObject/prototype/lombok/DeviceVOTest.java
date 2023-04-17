package com.hyomee.newObject.prototype.lombok;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeviceVOTest {

    @Test
    @DisplayName("lombok 상속 객체 생성")
    void deviceVO_lombok_01() {
        List<FunctionVO> functionVOs = List.of(
                new FunctionVO("F001", "통화기능"),
                new FunctionVO("F002", "영상기능")
        );

        DeviceVO deviceVo_00 = DeviceVO.builder()
                .model("S23")
                .serialNo("S23_0001")
                .company("삼성")
                .functionVOs(functionVOs)
                .build();

        DeviceVO deviceVo_01 = deviceVo_00.toBuilder()
                .functionVOs(FunctionVO.deepCopyList(deviceVo_00.getFunctionVOs()))
                .build();
        deviceVo_01.setModel("S45");
        deviceVo_01.setSerialNo("S45_0001");

        System.out.println(deviceVo_00.toString());
        System.out.println(deviceVo_01.toString());

    }
}