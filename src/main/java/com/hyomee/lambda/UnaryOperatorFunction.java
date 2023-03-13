package com.hyomee.lambda;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorFunction {

    public static void main(String... arg) {

        String 할인유형 = "01";
        double 금액 = 10000;

        // ⓐ UnaryOperator 함수형 인터페이스 람다 표현식
        UnaryOperator<Double> 기본할인 = a금액 -> a금액 - 1000.0;
        UnaryOperator<Double> 추가할인01 = a금액 -> a금액 - 3000.0;
        UnaryOperator<Double> 추가할인02 = a금액 -> a금액 - 4000.0;

        // ⓑ UnaryOperator 함수형 인터페이스 람다 표현식
        Function<Double, Double> 기본할인And추가할인01 =  기본할인.andThen(추가할인01);
        Function<Double, Double> 기본할인And추가할인02 =  기본할인.andThen(추가할인02);

        // ⓒ 함수 표현식 적용
        switch (할인유형) {
            case "01":
                금액 = 기본할인And추가할인01.apply(금액);
                break;
            case "02":
                금액 = 기본할인And추가할인02.apply(금액);
                break;
            default:
                금액 = 기본할인.apply(금액);
        }

        System.out.println(금액);
    }
}
