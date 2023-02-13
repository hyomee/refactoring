package com.hyomee.refactoring.introduceSpecialCase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IntroduceSpecialCase {

    private final PricePlan pricePlan;

    public int  client01(고객정보VO a고객정보VO) {
        return  a고객정보VO.is고객(a고객정보VO) ?
                pricePlan.get요율By요금제("일반요금제") :
                pricePlan.get요율By요금제(a고객정보VO.get고겍요금제())  ;

    }

    public int  client02(고객정보VO a고객정보VO) {
        return  a고객정보VO.is고객(a고객정보VO) ?
                pricePlan.get요율By요금제("일반요금제") :
                pricePlan.get요율By요금제(a고객정보VO.get고겍요금제())  ;
    }

    public int client03(고객정보VO a고객정보VO) {
        return  a고객정보VO.is고객(a고객정보VO) ?
                pricePlan.get요율By요금제("일반요금제") :
                pricePlan.get요율By요금제(a고객정보VO.get고겍요금제()) ;
    }

}

@Service
@RequiredArgsConstructor
class  SpecialCase{
    private final PricePlan pricePlan;

    public int client01(고객정보VO a고객정보VO) {

        String l_회원구분 = "";
        if (a고객정보VO.get회원구분().equals("비회원")) {
            l_회원구분 = "비회원";
        } else {
            l_회원구분 = a고객정보VO.get회원구분();
        }

        return l_회원구분.equals("비회원") ?
                pricePlan.get요율By요금제("일반요금제") :
                pricePlan.get요율By요금제(a고객정보VO.get고겍요금제())  ;
    }

    public int client02(고객정보VO a고객정보VO) {

        String l_요금제 = "";
        if (  a고객정보VO.get회원구분().equals("비회원")) {
            l_요금제 = "일반요금제";
        } else {
            l_요금제 = a고객정보VO.get고겍요금제();
        }

        return pricePlan.get요율By요금제(l_요금제);
    }

    public int client03(고객정보VO a고객정보VO) {

        return a고객정보VO.get회원구분().equals("비회원")?
                pricePlan.get요율By요금제("일반요금제") :
                pricePlan.get요율By요금제(a고객정보VO.get고겍요금제())  ;
    }
}
@Service
@RequiredArgsConstructor
class PricePlan {

    private int 요율;

    public int get요율By요금제(String 요금제) {
        // 요율 구하기
        return 0;
    }

}


@Data
@Builder
class 고객정보VO {
    private String 고객번호;
    private String 고겍요금제;
    private String 회원구분;

    public boolean is고객(고객정보VO a고객정보VO) {
        return ( a고객정보VO != null || a고객정보VO.get회원구분().equals("비회원")) ? false : true;
    }
}