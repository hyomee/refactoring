package com.hyomee.example35.e01.productPlan;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class EventSeniorPlan {

    // 1. 고등학교 2학년 대상 이벤트 대상 단말기
    @Getter
    @AllArgsConstructor
    public enum EVENT_MODEL_SENIOR {

        EVENT_2022_SENIOR(2022, List.of("Galaxy_12", "Galaxy_13", "Galaxy_14") ),
        EVENT_2023_SENIOR(2023,List.of("Galaxy_01", "Galaxy_02", "Galaxy_03") );
        private int eventYear;
        private  List<String> modelCds;
    }

    @Getter
    @AllArgsConstructor
    public enum EVENT_BENEFIT_SENIOR {
        EVENT_2022_SENIOR(2022, "PROD_VOD_003", 100000 ),
        EVENT_2023_SENIOR(2023,"PROD_VOD_001", 100000 );

        private int eventYear;
        private String addProductCode;
        private int deviceDcPrice;
    }
}
