package com.hyomee.newObject.prototype.lombok;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter(AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
@ToString
public class DeviceModelVO   {
    private String model;
    private String serialNo;
}
