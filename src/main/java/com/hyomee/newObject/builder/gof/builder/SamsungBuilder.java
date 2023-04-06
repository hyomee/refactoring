package com.hyomee.newObject.builder.gof.builder;


public class SamsungBuilder implements DeviceBuilder {
    private String id;
    private String brand;
    private String type;
    private String model;
    private String serialNo;
    private String color;

    @Override
    public SamsungBuilder id(String id) {
        this.id = id;
        return this;
    }

    @Override
    public DeviceBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public DeviceBuilder type(String type) {
        this.type = type;
        return this;
    }

    @Override
    public DeviceBuilder model(String model) {
        this.model = model;
        return this;
    }

    @Override
    public DeviceBuilder serialNo(String serialNo) {
        this.serialNo = serialNo;
        return this;
    }

    @Override
    public DeviceBuilder color(String color) {
        this.color = color;
        return this;
    }

    public DeviceVO build() {
        return new DeviceVO( this.id,
                this.brand,
                this.type,
                this.model,
                this.serialNo,
                this.color);
    }
}
