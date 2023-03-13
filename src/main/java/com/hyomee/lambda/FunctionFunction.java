package com.hyomee.lambda;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class FunctionFunction {

    /**
     * ⓐ 가입자의 상품 목록에서 상품가격을 반환
     * @param 가입상품Vos
     * @return
     */
    public Double 가입자상품가격(List<가입상품VO> 가입상품Vos) {

        /** ⓑ 가입자의 상품가격을 반한 **/
        List<Double> 가입상품가격s = map(가입상품Vos,
                (가입상품VO 가입상품vo) -> 가입상품vo.get상품가격());

        return 가입상품가격s.stream().reduce(0.0, Double::sum);
    }

    /**
     * 제네릭으로 List를 받아서 제너릭 리스트를 돌려준다
     */
    private <T, R> List<R> map(List<T> 목록s, Function<T,R> func) {
        List<R> result = new ArrayList<>();

        for( T t : 목록s) {
            result.add( func.apply(t));
        }

        return   result;
    }
}

@Data
@Builder
class 가입상품VO {
    private String 상품코드;
    private String 상품명;
    private double 상품가격;
}
