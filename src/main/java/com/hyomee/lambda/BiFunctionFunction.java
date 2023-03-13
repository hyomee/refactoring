package com.hyomee.lambda;

import java.util.function.BiFunction;

public class BiFunctionFunction {

    public static void main(String... args) {

        // ⓐ 두문자를 합치는 BiFunction 인터페이스를 적용한 람다 표현식
        BiFunction<Integer, String, String> 문자합침 = (i, s) -> i.toString() + s;
        System.out.println(문자합침.apply(12, "안녕")); // 1abc


        // ⓒ 두 객체를 비교하는 메서드 적용
        System.out.println(값비교("안녕", "안녕")); // true
        System.out.println(값비교("안녕", "안뇽")); // false

    }

    // ⓑ 두개의 갓을 비교하는 메서드로 비교 변수에 BiFunction 인터페이스를 적용한 람다 표현식
    public static <T, V> boolean 값비교(T t, V v) {
        BiFunction<T, V, Boolean> 비교 = (t1, v1) -> t1.equals(v1);
        return 비교.apply(t, v);
    }
}
