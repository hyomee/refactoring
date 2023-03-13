package com.hyomee.refactoring;

import lombok.*;

@Data
@Builder
public class SvcFtrVO {
    private String 이벤트코드;
    private String 요소코드;
    private String 파라메터;
}
