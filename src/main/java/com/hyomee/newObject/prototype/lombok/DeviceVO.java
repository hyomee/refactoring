package com.hyomee.newObject.prototype.lombok;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.LinkedList;
import java.util.List;
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
public class DeviceVO extends DeviceModelVO {
    private String company;
    private List<FunctionVO> functionVOs;

}
