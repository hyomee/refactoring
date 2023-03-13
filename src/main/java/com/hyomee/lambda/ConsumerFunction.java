package com.hyomee.lambda;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
@Slf4j
public class ConsumerFunction {

    /**
     * 상품객체를 받아서 기본 1000원 할인을 적용 하는 기능
     * @param 상품vo
     */
    public void 상품금액기본할인요율적용(상품VO 상품vo) {

        final double  기본할인금액 = 1000.0;

        /** 상품 객체를 받아서 상품의 요금에 기본할인금액을 적용하는 Consumer 함수형 인터페이스 **/
        Consumer<상품VO> consumer = (상품VO p상품vo) -> p상품vo.set요금상품금액(p상품vo.get요금상품금액() - 기본할인금액);

        /** 기본 할인을 적용하기 위해서  기본할인요율적용 메서드 호출 **/
        기본할인요율적용(상품vo, consumer);

    }

    /**
     * Consumer 인터페이스를 실제 실핸 하는 기본할인요율적용 메서드
     * @param t
     * @param consumer
     * @param <T>
     */
    public <T> void 기본할인요율적용(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }
}


@Data
@Builder
class 상품VO {
    private String 가입자ID;
    private double 요금상품금액;
}