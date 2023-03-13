package com.hyomee.lambda;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SupplierFunction {

    public List<가입자상품VO> 부가상품_A자동추가(List<가입자상품VO> 가입자상품목록vos) {
       final String 추가상품 = "부가상품_A";

       List<가입자상품VO> rn가입자상품목록vos = 가입자상품목록vos.stream().collect(Collectors.toList());

       boolean isAdd = rn가입자상품목록vos.stream().anyMatch(가입자상품V0 -> 추가상품.equals(가입자상품V0.get상품명()));
       if (!isAdd) {
           가입자상품VO 가입자상품vo = 가입자상품VO.builder()
                   .가입자id(rn가입자상품목록vos.get(0).get가입자id())
                   .상품명(추가상품)
                   .build();

           rn가입자상품목록vos.add(가입자상품vo);
       }

       return rn가입자상품목록vos;
    }

    public List<가입자상품VO> supplier_부가상품_A자동추가(List<가입자상품VO> 가입자상품목록vos) {
        final String 추가상품 = "부가상품_A";

        List<가입자상품VO> rn가입자상품목록vos = 가입자상품목록vos.stream().collect(Collectors.toList());

        boolean isAdd = rn가입자상품목록vos.stream().anyMatch(가입자상품V0 -> 추가상품.equals(가입자상품V0.get상품명()));

        Supplier<가입자상품VO> supplier가입상품vo = () -> 가입자상품VO.builder()
                .가입자id(rn가입자상품목록vos.get(0).get가입자id())
                .상품명(추가상품)
                .build();

        if (!isAdd) {
            rn가입자상품목록vos.add(supplier가입상품vo.get());
        }

        return rn가입자상품목록vos;
    }

    public void 필요한데이터얻기(List<HashMap> 장비값목록) {
        long startTime = System.currentTimeMillis();
        List<String> 데이터s = 필요한데이터얻기_일반(  장비값목록);
        log.debug(데이터s.toString());
        log.debug(String.format("총시간 %d 초" ,
                (System.currentTimeMillis() - startTime) / 1000));
        log.debug("=================================================");

        startTime = System.currentTimeMillis();
        데이터s = 필요한데이터얻기_Supplier( 장비값목록);
        log.debug(데이터s.toString());
        log.debug(String.format("총시간 %d 초" ,
                (System.currentTimeMillis() - startTime) / 1000));
    }

    private List<String> 필요한데이터얻기_일반(List<HashMap> 장비값목록) {

        List<String> 데이터s = new LinkedList<>();
        for ( HashMap 장비 : 장비값목록) {
            String msg = 값얻기((Integer) 장비.get("숫자"), 조건에맞는값((String) 장비.get("메세지")));
            if (StringUtils.isNotEmpty(msg)){
                데이터s.add(msg);
            }
        }
        return 데이터s;
    }
    private  List<String>  필요한데이터얻기_Supplier(List<HashMap> 장비값목록) {

        List<String> 데이터s = new LinkedList<>();
        for ( HashMap 장비 : 장비값목록) {
            String msg = 값얻기Supplier((Integer) 장비.get("숫자"), ()->조건에맞는값((String) 장비.get("메세지")));
            if (StringUtils.isNotEmpty(msg)){
                데이터s.add(msg);
            }
        }
        return 데이터s;
    }

    private String 조건에맞는값(String iotValue) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return iotValue.contains("온도") ? iotValue : "" ;
    }

    private String 값얻기(int num, String msg) {
        if ( num >= 0 ) {
            return msg;
        } else {
            return "";
        }

    }

    private String 값얻기Supplier(int num, Supplier<String> msg) {
        if ( num >= 0 ) {
            return msg.get();
        } else {
            return "";
        }

    }

}

@Getter
@Builder
class 가입자상품VO {
    private String 가입자id;
    private String 상품명;
}
