package com.hyomee.newObject.builder.gof.builder;

public class AppleBuilder implements DeviceBuilder {
    private String id;
    private String brand;
    private String type;
    private String model;
    private String serialNo;
    private String color;

    @Override
    public AppleBuilder id(String id) {
        this.id = id;
        return this;
    }

    @Override
    public AppleBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public AppleBuilder type(String type) {
        this.type = type;
        return this;
    }

    @Override
    public AppleBuilder model(String model) {
        this.model = model;
        return this;
    }

    @Override
    public AppleBuilder serialNo(String serialNo) {
        this.serialNo = serialNo;
        return this;
    }

    @Override
    public AppleBuilder color(String color) {
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
