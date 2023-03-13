package com.hyomee.lambda;


import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorFunction {
    public static void main(String... args) {

        실행_runnable();

    }


    private static void 삼품비교_comparable() {

        List<상품비교VO> 상품비교VOs = Arrays.asList(
                상품비교VO.builder().상품코드("V1001").요금(10000).build(),
                상품비교VO.builder().상품코드("V1002").요금(22000).build(),
                상품비교VO.builder().상품코드("V1003").요금(14000).build()
        );

        // 상품비교VOs를 복사 하기 ( List안에 있는 상품비교VO 객체 DeepCopy
        //
        List<상품비교VO> 상품비교VO람다s = 상품비교VOs.stream().map(상품비교VO :: deepCopy).collect(Collectors.toList());

        // JAVA 1.8 이하에서 comparable를 사용한 정렬
        Collections.sort(상품비교VOs);
        for (상품비교VO a상품비교VO : 상품비교VOs) {
            System.out.println(a상품비교VO.toString());
        }

        // JAVA 1.8이상에서 람다 표현식을 사용한 정렬
        Collections.sort(상품비교VO람다s ,
                (a상품비교_01VO, b상품비교_01VO) -> Integer.compare(a상품비교_01VO.get요금(), b상품비교_01VO.get요금()));

        for (상품비교VO a품비교VO : 상품비교VO람다s) {
            System.out.println(a품비교VO.toString());
        }
    }

    private static void 상품품비교_comparable람다(List<상품비교_01VO> 상품비교_01VOs ) {
        Collections.sort(상품비교_01VOs , (a상품비교_01VO, b상품비교_01VO) -> Integer.compare(a상품비교_01VO.get요금(), b상품비교_01VO.get요금()));
        for (상품비교_01VO a상품비교_01VO : 상품비교_01VOs) {
            System.out.println(a상품비교_01VO.toString());
        }
    }

    private static void 상품품비교_Comparator( ) {

        // Comparator 인터페이스를 사용하기 위한 데이터
        List<상품비교_01VO> 상품비교_01VOs = Arrays.asList(
                상품비교_01VO.builder().상품코드("V1001").요금(10000).build(),
                상품비교_01VO.builder().상품코드("V1002").요금(22000).build(),
                상품비교_01VO.builder().상품코드("V1003").요금(14000).build()
        );

        // ⓐ 익명 클래스를 사용한 Comparator
        Collections.sort(상품비교_01VOs, new Comparator<상품비교_01VO>() {
            @Override
            public int compare(상품비교_01VO s1, 상품비교_01VO t1) {
                return Integer.compare(s1.get요금(), t1.get요금());
            }
        });

        for (상품비교_01VO a상품비교_01VO : 상품비교_01VOs) {
            System.out.println(a상품비교_01VO.toString());
        }

        // 람다 표현식으로 사용하기 위한 데이터
        List<상품비교_01VO> 상품비교_01VO람다s = Arrays.asList(
                상품비교_01VO.builder().상품코드("V1001").요금(10000).build(),
                상품비교_01VO.builder().상품코드("V1002").요금(22000).build(),
                상품비교_01VO.builder().상품코드("V1003").요금(14000).build()
        );

        // 람다 표현식으로 사용한 Comparator
        상품비교_01VO람다s.sort(Comparator.comparing(상품비교_01VO :: get요금));

        for (상품비교_01VO a상품비교_01VO : 상품비교_01VO람다s) {
            System.out.println(a상품비교_01VO.toString());
        }
    }


    private static void 실행_runnable() {

        // ⓐ 자바 1.8이하에서 새로운 쓰레드를 생성 하는 방법 중 익명 클래스를 사용한 코드
        Thread 새로운쓰레드 = new Thread((new Runnable() {
            @Override
            public void run() {
                System.out.println("새로운쓰레드");
            }
        }));

        새로운쓰레드.run();

        // ⓑ 익명 클래스를 람다 표현식으로 변경한 코드
        Thread 새로운쓰레드람다 = new Thread(()-> {
            System.out.println("새로운쓰레드람다");
        });

        새로운쓰레드람다.run();

        // ⓒ 람다표현식을 축약한 코드
        Runnable 새로운쓰레드람다축약 = () ->  System.out.println("새로운쓰레드람다축약");
        새로운쓰레드람다축약.run();
    }

}


@Data
@Builder(toBuilder = true)
class 상품비교VO implements Comparable<상품비교VO> {
    private String 상품코드;
    private int 요금;

    @Override
    public int compareTo(상품비교VO a상품비교VO) {
        return Integer.compare(this.요금, a상품비교VO.get요금());
    }

    public static 상품비교VO deepCopy(상품비교VO a상품비교CO) {
        return a상품비교CO.toBuilder().build();
    }
}

@Data
@Builder
class 상품비교_01VO   {
    private String 상품코드;
    private int 요금;

}


