package com.hyomee.refactoring.conditionRefactoring;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class Polymorphism {



    public double getRate(고객정보VO a고객정보VO, 판매정보VO a판매정보VO) {
        double l판매금액 = a판매정보VO.get판매금액();
        double 금액 = 0.0;
        switch ( a고객정보VO.get고객등급() ) {
            case "1등급":
                금액 = l판매금액 - (l판매금액 * 0.07) ;
                if ( a고객정보VO.is신규여부() )  금액 = l판매금액 - (l판매금액 *  0.1);
                if ( l판매금액 > 500000 ) {
                    double l기간할인금액 = a고객정보VO.get가입기간() * 2000 ;
                    l기간할인금액 =  l기간할인금액 > 20000 ? 20000 :  l기간할인금액;
                    금액 =  금액 - l기간할인금액;
                }
                return 금액;
            case "2등급":
                금액 = l판매금액 - (l판매금액 * 0.05) ;
                if ( a고객정보VO.is신규여부() )  금액 = l판매금액  - (l판매금액 * 0.1);
                if ( l판매금액 > 500000 ) {
                    double l기간할인금액 = a고객정보VO.get가입기간() * 2000 ;
                    l기간할인금액 =  l기간할인금액 > 20000 ? 20000 :  l기간할인금액;
                    금액 =  금액 - l기간할인금액;
                }
                return 금액;
            case "3등급":
                금액 = l판매금액 - (l판매금액 * 0.03) ;
                if ( a고객정보VO.is신규여부() )  금액 = l판매금액  - (l판매금액 * 0.1);
                if ( l판매금액 > 500000 ) {
                    double l기간할인금액 = a고객정보VO.get가입기간() * 2000 ;
                    l기간할인금액 =  l기간할인금액 > 20000 ? 20000 :  l기간할인금액;
                    금액 =  금액 - l기간할인금액;
                }
                return 금액;
            default:
                if ( a고객정보VO.is신규여부() ) 금액 = l판매금액  - (l판매금액 * 0.1);
                return 금액;
        }
    }

    public double getRateRefactoring(고객정보VO a고객정보VO, 판매정보VO a판매정보VO) {
        슈퍼등급요금 p슈퍼등급요금 ;
        switch ( a고객정보VO.get고객등급() ) {
            case "1등급":
                p슈퍼등급요금 =  new 요금_1등급();
                break;
            case "2등급":
                p슈퍼등급요금 =  new 요금_2등급();
                break;
            case "3등급":
                p슈퍼등급요금 =  new 요금_3등급();
                break;
            default:
                p슈퍼등급요금 =  new 요금_기본();
        }

        p슈퍼등급요금.get요금계산(a고객정보VO,  a판매정보VO);
        return p슈퍼등급요금.get금액();
    }
}


@Data
@Builder
class 고객정보VO {
    private String 고객번호;
    private String 고객명;
    private String 고객등급;

    private int 가입기간;
    private boolean 신규여부;
}

@Data
@Builder
class 판매정보VO {
    private String 고격번호;
    private Double 판매금액;
}



@Getter
abstract class 슈퍼등급요금 {
    protected double 금액 = 0.0;
    abstract void get요금계산(고객정보VO a고객정보VO, 판매정보VO a판매정보VO);

    double 등급별할인금액계산(double l판매금액, double dcRate) {
        return l판매금액 - (l판매금액 * dcRate);
    }

    double 신규가입할인금액계산(double l판매금액, double dcRate) {
        return l판매금액 - (l판매금액 * dcRate);
    }

    double 기간할인금액계산(int a가입기간, double l판매금액) {
        if ( l판매금액 > 500000 ) {
            double l기간할인금액 = a가입기간 * 2000;
            l기간할인금액 = l기간할인금액 > 20000 ? 20000 : l기간할인금액;
            return l기간할인금액;
        }

        return 0.0;
    }

    protected void 할인통합계산(고객정보VO a고객정보VO, 판매정보VO a판매정보VO, double dcRate) {
        double l판매금액 = a판매정보VO.get판매금액();
        this.금액 = 등급별할인금액계산(l판매금액, dcRate) ;
        if ( a고객정보VO.is신규여부() )  금액 = 신규가입할인금액계산(l판매금액, 0.1);
        this.금액 =  금액 - 기간할인금액계산(a고객정보VO.get가입기간(), l판매금액);

    }
}

@Service
class 요금_1등급 extends 슈퍼등급요금{

    void get요금계산(고객정보VO a고객정보VO, 판매정보VO a판매정보VO) {
        double l판매금액 = a판매정보VO.get판매금액();
        super.금액 = 등급별할인금액계산(l판매금액, 0.07) ;
        if ( a고객정보VO.is신규여부() )  super.금액 = 신규가입할인금액계산(l판매금액, 0.1);
        super.금액 =  super.금액 - 기간할인금액계산(a고객정보VO.get가입기간(), l판매금액);
    }

}

@Service
class 요금_2등급 extends 슈퍼등급요금{
    void get요금계산(고객정보VO a고객정보VO, 판매정보VO a판매정보VO) {
        super.할인통합계산( a고객정보VO,  a판매정보VO, 0.05);
    }
}

@Service
class 요금_3등급 extends 슈퍼등급요금{

    void get요금계산(고객정보VO a고객정보VO, 판매정보VO a판매정보VO) {
        super.할인통합계산( a고객정보VO,  a판매정보VO, 0.03);
    }
}

class 요금_기본 extends 슈퍼등급요금 {

    void get요금계산(고객정보VO a고객정보VO, 판매정보VO a판매정보VO) {
        double l판매금액 = a판매정보VO.get판매금액();
        if ( a고객정보VO.is신규여부() ) super.금액 = l판매금액  - (l판매금액 * 0.1);
    }
}