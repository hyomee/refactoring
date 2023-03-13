package com.hyomee.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class java17Compare {

    public static void main(String... args) {
        List<Integer> 숫자들 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // ⓐ 자바 1.7 코드로 작성 한 코드
        List<Integer> 나머지_0 = new ArrayList<>();

        for (Integer 숫자 : 숫자들) {
            if ( 숫자 % 2 == 0) {
                나머지_0.add(숫자);
            }
        }
        System.out.println(String.format("자바 1.7 사용 : %s", 나머지_0.toString()));

        // ⓑ 스트림을 사용한 코드
        List<Integer> 스트림나머지_0 = 숫자들.stream()
                .filter(숫자-> 숫자 % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(String.format("스트림 사용 : %s", 스트림나머지_0.toString()));
    }

}
