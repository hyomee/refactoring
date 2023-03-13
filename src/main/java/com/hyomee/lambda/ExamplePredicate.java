package com.hyomee.lambda;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ExamplePredicate {

    /**
     * 가입자목록울 받아서 가입자의 요금금액이 60.000원 이상인 가입자 선택/추출
     * @param 가입자VOs
     * @return
     */
    public List<가입자VO> hdtv추가상품(List<가입자VO> 가입자VOs) {
        final double hdtv추가상품기준금액 = 60000;

        /** Predicate 함수형 인터페이스를 이용항 조건 람다 표현식 **/
        Predicate<가입자VO> hdtv추사부가상품대상
                = (가입자VO 가입자vo) -> hdtv추가상품기준금액 <= 가입자vo.get요금상품금액();

        /** HDTV 부가 상품 추가 대상자 선택.추출 호출 **/
        return 추가대상(가입자VOs, hdtv추사부가상품대상);
    }

    /**
     * 가입자 목록과 Predicate 함수형 인터페이스를 조건을 받아서 조건에 대한 하는 대상자 선택/추출
     * @param 목록
     * @param 조건
     * @return
     * @param <T>
     */
    public <T> List<T> 추가대상(List<T> 목록, Predicate<T> 조건) {
        List<T> 추가대상s = new ArrayList<>();
        for (T t: 목록) {
            /** 함수형 인터테이스의 test 구현 **/
            if (조건.test(t)) {
                추가대상s.add(t);
            }
        }
        return 추가대상s;
    }
}

@Data
@Builder
class 가입자VO {
    private String 가입자ID;
    private double 요금상품금액;
}


