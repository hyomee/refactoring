package com.hyomee.example35.e00;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class soc {

    private static List<Integer> dataList = Arrays.asList(1,4,8,2,5,9,7);
    public static void main(String... aegs) {
        List<Integer> noSoCmixMaxs = noSeparationOfInterests();
        System.out.println("SoC 미적용 : " +  noSoCmixMaxs);

        List<Integer> soCmixMaxs = separationOfInterests();
        System.out.println("SoC 적용 : " +  soCmixMaxs);
    }

    // SoC 마적용 메서드
    private static List<Integer> noSeparationOfInterests() {
        Collections.sort(dataList);
        int min = dataList.get(0);
        int max = dataList.get(dataList.size()-1);
        return Arrays.asList(min,max);
    }

    // SoC 적용을 위한 최소값 구하기
    private static int getMin() {
        return dataList.get(0);
    }

    // SoC 적용을 위한 최대값 구하기
    private static int getMax() {
        return dataList.get(dataList.size()-1);
    }
    // SoC 적용 메서드
    private static List<Integer> separationOfInterests() {
        Collections.sort(dataList);
        int min = getMin();
        int max = getMax();
        return Arrays.asList(min,max);
    }


}
