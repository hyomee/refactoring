package com.hyomee.newObject.builder.gof.builder;



public interface DeviceBuilder {
    DeviceBuilder id(String id) ;
    DeviceBuilder brand(String brand);
    DeviceBuilder type(String type);
    DeviceBuilder model(String model);
    DeviceBuilder serialNo(String serialNo);
    DeviceBuilder color(String color);


}
