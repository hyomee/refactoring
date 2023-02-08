package com.hyomee.refactoring.conditionRefactoring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Log4j2
public class DecomposeContioanal {

    public int mobilePhonePrice(CustSaleInfoVO custSaleInfoVO) {

        // 현재 정책 가지고 오기
        SatPolicy.SatPricePolicy satPricePolicy = SatPolicy.SatPricePolicy.valueOf("POLICY_" + custSaleInfoVO.getSaleDate().getYear())

        if (  satPricePolicy.getSatPolicyStartDate().compareTo(custSaleInfoVO.getSaleDate()) >= 0 &&
                        custSaleInfoVO.getSaleDate().compareTo(satPricePolicy.getSatPolicyEndDate()) >=0 ) {

        } else {

        }
        return 0
    }
}

@Data
@Builder
class CustSaleInfoVO {

    private int mobilePhonePrice;
    private LocalDate saleDate;

    boolean admissionTiketProvided;
}



class SatPolicy {
    @Getter
    @AllArgsConstructor
    enum SatPricePolicy {

        POLICY_2022(LocalDate.of(2022, 11, 15),
                LocalDate.of(2022, 12, 31),
                30,
                SatGiftPolicy.POLICY_2022),
        POLICY_2023(LocalDate.of(2023, 11, 17),
                LocalDate.of(2023, 12, 31),
                40,
                SatGiftPolicy.POLICY_2023);

        private LocalDate satPolicyStartDate;
        private LocalDate satPolicyEndDate;
        int satDcRate;
        private SatGiftPolicy satGiftPolicy;
    }

    @Getter
    @AllArgsConstructor
    enum SatGiftPolicy {

        POLICY_2022(List.of("강화액정보호필름", "고급케이스", "믈루투스스피커")),
        POLICY_2023(List.of("강화액정보호필름", "고급케이스", "블루투스이어폰"));

        private List<String> gifts;

    }

    @Getter
    @AllArgsConstructor
    enum ModelPolicy {

        POLICY_2002(List.of( List.of("삼성", 1000000))) ;
//        POLICY_2003(List.of(List.of("아이폰", 1300000),
//                            List.of("삼성", 1200000)) ;

        private List<List<String>>  models;
        private String modelNm;
        private int salePrice;


    }

}



