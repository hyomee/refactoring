package com.hyomee.refactoring.ecapsulate;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReplaceTempWithQuery {

    public String mms지원단말부가상품추가(String 모델) {
        String 상품 = "";
        final String 기능 = "FNC_00004";
        boolean isMms지원 =  단말기기능체크유틸.단말기기능체크(모델,기능 );
        if (isMms지원) {
            상품 = "추가상품";
        }


        return 상품 ;
    }
}


class 단말기기능체크유틸 {
    public static boolean 단말기기능체크(String 모델, String 기능) {
        return Arrays.stream(단말기.values())
                .filter(단말모델->단말모델.getDevCd().equals(모델))
                .map(단말기::getDevFuncs)
                .collect(Collectors.toList())
                .get(0)
                .stream()
                .anyMatch(단말기능-> 기능.equals(단말기능));
    }
}

@Getter
@AllArgsConstructor
enum 단말기기능 {

    FNC_00001("FNC_00001", "영상지원"),
    FNC_00002("FNC_00002", "음성지원"),
    FNC_00003("FNC_00003", "SMS지원"),
    FNC_00004("FNC_00004", "MMS지원");


    private String funcCd;
    private String funcNm;

}

@Getter
@AllArgsConstructor
enum 단말기 {

    DEV_0001("MDL_0001", Arrays.asList("FNC_0001", "FNC_0002")),
    DEV_0002("MDL_0002", Arrays.asList("FNC_0001", "FNC_0002", "FNC_00003")),
    DEV_0003("MDL_0003", Arrays.asList("FNC_0001", "FNC_0002", "FNC_00003", "FNC_00004"));
    private String devCd;
    private List<String> devFuncs;

}