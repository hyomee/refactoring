package com.hyomee.newObject.builder.lombok;

import lombok.Builder;

public class LomBokMethodVO {
    private String name;
    private String age;

    @Builder
    public LomBokMethodVO(String name) {
        this.name = name ;
    }
}
