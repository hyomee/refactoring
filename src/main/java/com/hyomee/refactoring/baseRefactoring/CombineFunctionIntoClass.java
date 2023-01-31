package com.hyomee.refactoring.baseRefactoring;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Log4j2
public class CombineFunctionIntoClass {
    private CustDTO custDTO;

    public void initData() {
        CustDTO custDTO = CustDTO.builder()
                .pricePlanProdCd("LPZ0000001")
                .procePlanRate(75000)
                .joinMonth(5)
                .joinYear(2015)
                .build();
    }


}

// case 1 : 요금 상품 금액의 금액은 가입년수에 따라서 1년에 1000원 할인 ( 요금 기본 요율의 50% 보단 작으면 50% 적용  )
//          요금 상품 기본 금액의 높을 수록 할인률은 다은과 같다
//              - 50,000 미만 1구간 ( -5,000 )
//              - 50,000 ~ 100,000 2구간 ( -10,000 )
//              - 100,000 이상  2구간 ( -15,000 )


@Setter
@Getter
@Builder
class CustDTO {
    private String pricePlanProdCd;     // 요굼제 코드
    private int procePlanRate;          // 기본 요금
    private int joinMonth;              // 가입 월
    private int joinYear;               // 가입 년

    public static CustDTO makeCustDTO(String pricePlanProdCd,
                              int procePlanRate,
                              int joinMonth,
                              int joinYear) {
        return CustDTO.builder()
                .pricePlanProdCd(pricePlanProdCd)
                .procePlanRate(procePlanRate)
                .joinMonth(joinMonth)
                .joinYear(joinYear)
                .build();

    }
}

@Service
@Log4j2
class Client01 {

    int calculationOfPricePlan() {
        CustDTO custDTO = ClientUtils.getCust();
        int usePeriodDcRate = usePeriod(custDTO.getJoinMonth(), custDTO.getJoinYear()) * ClientUtils.DC_RATE_USERATE ;
        int procePlanHalfRate = Integer.parseInt(String.valueOf((custDTO.getProcePlanRate() / 2 )));
        int pricePlanRate =  usePeriodDcRate > procePlanHalfRate ? procePlanHalfRate : custDTO.getProcePlanRate() - usePeriodDcRate;

        int sectionDcRate = ClientUtils.sectionDcRate(custDTO.getProcePlanRate());
        int pricePlanRateTmp = pricePlanRate - sectionDcRate;

        if (pricePlanRate >= pricePlanRateTmp) return pricePlanRate;
        return pricePlanRateTmp;
    }

    // 가입년수에 따라서 1년에 1000원 할인
    int usePeriod(int joinMonth, int joinYear) {
        return  ((ClientUtils.MONTH - joinMonth) + ( ( ClientUtils.getNowYear() - joinYear ) * ClientUtils.MONTH )) ;
    }



}

@Service
@Log4j2
class client02 {

    int calculationOfPricePlan() {
        CustDTO custDTO = ClientUtils.getCust();
        return pricePlanRate( custDTO );
    }

    // 가입년수에 따라서 1년에 1000원 할인
    int usePeriod(int joinMonth, int joinYear) {
        return  ((ClientUtils.MONTH - joinMonth) + ( ( ClientUtils.getNowYear() - joinYear ) * ClientUtils.MONTH )) ;
    }

    int pricePlanRate(CustDTO custDTO ) {
        int usePeriodDcRate = usePeriod(custDTO.getJoinMonth(), custDTO.getJoinYear()) * ClientUtils.DC_RATE_USERATE ;

        int procePlanHalfRate = Integer.parseInt(String.valueOf((custDTO.getProcePlanRate() / 2 )));
        int pricePlanRate =  usePeriodDcRate > procePlanHalfRate ? procePlanHalfRate : custDTO.getProcePlanRate() - usePeriodDcRate;

        int sectionDcRate = ClientUtils.sectionDcRate(custDTO.getProcePlanRate());
        int pricePlanRateTmp = pricePlanRate - sectionDcRate;

        if (pricePlanRate >= pricePlanRateTmp) return pricePlanRate;
        return pricePlanRateTmp;
    }
}

@Service
@Log4j2
class client03 {

    int calculationOfPricePlan() {
        CustDTO custDTO = ClientUtils.getCust();
        int usePeriodDcRate = usePeriod(custDTO.getJoinMonth(), custDTO.getJoinYear()) * ClientUtils.DC_RATE_USERATE ;
        int pricePlanRate = pricePlanRate(usePeriodDcRate, custDTO.getProcePlanRate());
        int pricePlanRateTmp = pricePlanRateTmp(pricePlanRate);
        return (pricePlanRate >= pricePlanRateTmp) ? pricePlanRate : pricePlanRateTmp;
    }

    // 가입년수에 따라서 1년에 1000원 할인
    int usePeriod(int joinMonth, int joinYear) {
        return  ((ClientUtils.MONTH - joinMonth) + ( ( ClientUtils.getNowYear() - joinYear ) * ClientUtils.MONTH )) ;
    }

    int pricePlanRate(int usePeriodDcRate, int  procePlanRate ) {
        int procePlanHalfRate = Integer.parseInt(String.valueOf((procePlanRate / 2 )));
        return  usePeriodDcRate > procePlanHalfRate ? procePlanHalfRate : procePlanRate - usePeriodDcRate;
    }

    int pricePlanRateTmp(int pricePlanRate ) {
        int sectionDcRate = ClientUtils.sectionDcRate(pricePlanRate);
        return pricePlanRate - sectionDcRate;
    }

}

class ClientUtils {

    static final int MONTH = 12;
    static final int DC_RATE_USERATE = 1000;
    static CustDTO getCust() {
        return CustDTO.builder()
                .pricePlanProdCd("LPZ0000001")
                .procePlanRate(75000)
                .joinMonth(5)
                .joinYear(2015)
                .build();
    }

    static int getNowMonth() {
        LocalDate now = LocalDate.now() ;
        return now.getMonthValue();
    }

    static int getNowYear() {
        LocalDate now = LocalDate.now() ;
        return now.getYear();
    }

    // 50,000 미만 1구간 ( -5,000 )
    // 50,000 ~ 100,000 2구간 ( -10,000 )
    //  100,000 이상  2구간 ( -15,000 )
    static int sectionDcRate(int pricePlanRate) {
        if ( pricePlanRate < 5000) return 5000;
        if ( pricePlanRate > 100000) return 15000;
        return 10000;
    }

}

// 새로운 Class
@Service
class PricePlanRate {
    int usePeriod(int joinMonth, int joinYear) {
        return  ((ClientUtils.MONTH - joinMonth) + ( ( ClientUtils.getNowYear() - joinYear ) * ClientUtils.MONTH )) * ClientUtils.DC_RATE_USERATE;
    }

    int pricePlanRate(int usePeriodDcRate, int  procePlanRate ) {
        int procePlanHalfRate = Integer.parseInt(String.valueOf((procePlanRate / 2 )));
        return  usePeriodDcRate > procePlanHalfRate ? procePlanHalfRate : procePlanRate - usePeriodDcRate;
    }

    int pricePlanRateTmp(int pricePlanRate ) {
        int sectionDcRate = ClientUtils.sectionDcRate(pricePlanRate);
        return pricePlanRate - sectionDcRate;
    }

    int pricePlanRate(CustDTO custDTO) {
        int usePeriodDcRate = usePeriod(custDTO.getJoinMonth(), custDTO.getJoinYear()) * ClientUtils.DC_RATE_USERATE ;
        int pricePlanDcRate = pricePlanRate(usePeriodDcRate, custDTO.getProcePlanRate());
        int pricePlanDcRateTmp = pricePlanRateTmp(pricePlanDcRate);
        return (pricePlanDcRate >= pricePlanDcRateTmp) ? pricePlanDcRate : pricePlanDcRateTmp;
    }
}

@RequiredArgsConstructor
@Service
@Log4j2
class Client01Refactoring {
    private final PricePlanRate pricePlanRate;

    int calculationOfPricePlan() {
        CustDTO custDTO = ClientUtils.getCust();
        int usePeriodDcRate = pricePlanRate.usePeriod(custDTO.getJoinMonth(), custDTO.getJoinYear()) * ClientUtils.DC_RATE_USERATE ;
        int pricePlanDcRate = pricePlanRate.pricePlanRate(usePeriodDcRate, custDTO.getProcePlanRate());
        int pricePlanDcRateTmp = pricePlanRate.pricePlanRateTmp(pricePlanDcRate);
        return (pricePlanDcRate >= pricePlanDcRateTmp) ? pricePlanDcRate : pricePlanDcRateTmp;
    }
}

@RequiredArgsConstructor
@Service
@Log4j2
class Client02Refactoring {
    private final PricePlanRate pricePlanRate;

    int calculationOfPricePlan() {
        CustDTO custDTO = ClientUtils.getCust();
        int usePeriodDcRate = pricePlanRate.usePeriod(custDTO.getJoinMonth(), custDTO.getJoinYear()) * ClientUtils.DC_RATE_USERATE ;
        int pricePlanDcRate = pricePlanRate.pricePlanRate(usePeriodDcRate, custDTO.getProcePlanRate());
        int pricePlanDcRateTmp = pricePlanRate.pricePlanRateTmp(pricePlanDcRate);
        return (pricePlanDcRate >= pricePlanDcRateTmp) ? pricePlanDcRate : pricePlanDcRateTmp;
    }
}

@RequiredArgsConstructor
@Service
@Log4j2
class Client03Refactoring {
    private final PricePlanRate pricePlanRate;

    int calculationOfPricePlan() {
        return pricePlanRate.pricePlanRate(ClientUtils.getCust());
    }
}