package com.hyomee.lambda;


public class CustomFunctionClass {
    public static void main(String... args) {

        // ⓐ 익명 클래스로 선언
        ThreeFunction<Integer, Integer,Integer, Integer>  계산익명 =
                new ThreeFunction<Integer, Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer x, Integer y, Integer z) {
                        return  x + y +z;
                    }
                };

        // ⓐ 익명 클래스로 선언 한 클래스 실행
        System.out.println(String.format("익명 클래스 : %d ", 계산익명.apply(10, 20, 30)));

        // ⓒ 람다표현식 선언
        ThreeFunction<Integer, Integer,Integer, Integer>  계산람다 = (x, y, z) -> x + y +z ;

        // ⓓ 람다표현식 선언 실행
        System.out.println(String.format("람다 : %d ", 계산람다.apply(10, 20, 30)));
    }

}


