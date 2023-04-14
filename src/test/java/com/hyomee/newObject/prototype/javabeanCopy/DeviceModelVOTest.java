package com.hyomee.newObject.prototype.javabeanCopy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeviceModelVOTest {

    @Test
    @DisplayName("단말기 객체 생성")
    void createDeviceVO_TEST() {
        List<FunctionVO> functionVOs = List.of(
                new FunctionVO("F001", "통화기능"),
                new FunctionVO("F002", "영상기능")
        );


        DeviceVO deviceVO = new DeviceVO("S32", "S32_00001", "삼성", functionVOs);
        DeviceVO deviceVO_01 = (DeviceVO) deviceVO.clone();
        deviceVO_01.setModel("S45");
        deviceVO_01.setSerialNo("S45_00001");
        deviceVO_01.getFunctionVOs().add(new FunctionVO("F003", "MMS"));

        DeviceVO deviceVO_02 = (DeviceVO) deviceVO.clone();
        deviceVO_02.setModel("A01");
        deviceVO_02.setSerialNo("A01_00001");
        deviceVO_02.setCompany("애플");

        System.out.println("DeviceVO    : " + deviceVO.toString());
        System.out.println("deviceVO_01 : " + deviceVO_01.toString());
        System.out.println("deviceVO_02 : " + deviceVO_02.toString());
    }

    @Test
    @DisplayName("프로토타입 패턴으로 단말기 객체 생성")
    void createDeviceVO_TEST_01() {
        List<FunctionVO> functionVOs = List.of(
                new FunctionVO("F001", "통화기능"),
                new FunctionVO("F002", "영상기능")
        );


        DeviceVO deviceVO = new DeviceVO("S32", "S32_00001", "삼성", functionVOs);
        DeviceVO deviceVO_01 = (DeviceVO) deviceVO.clone();
        deviceVO_01.setModel("S45");
        deviceVO_01.setSerialNo("S45_00001");
        deviceVO_01.getFunctionVOs().add(new FunctionVO("F003", "MMS"));

        DeviceVO deviceVO_02 = (DeviceVO) deviceVO.clone();
        deviceVO_02.setModel("A01");
        deviceVO_02.setSerialNo("A01_00001");
        deviceVO_02.setCompany("애플");

        System.out.println("DeviceVO    : " + deviceVO.toString());
        System.out.println("deviceVO_01 : " + deviceVO_01.toString());
        System.out.println("deviceVO_02 : " + deviceVO_02.toString());
    }

}