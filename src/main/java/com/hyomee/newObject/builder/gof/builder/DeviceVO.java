package com.hyomee.newObject.builder.gof.builder;

public class DeviceVO {
    private String id;
    private String brand;
    private String type;
    private String model;
    private String serialNo;
    private String color;


    public DeviceVO(String id,
                    String brand,
                    String type,
                    String model,
                    String serialNo,
                    String color) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.model = model;
        this.serialNo = serialNo;
        this.color = color;
    }

    @Override
    public String toString() {
        return "DeviceVO{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", color='" + color + '\'' +
                '}';
    }


}
