package com.hyomee.example35.e01.event;

import com.hyomee.example35.e01.event.vo.BenefitVO;
import com.hyomee.example35.e01.event.vo.SaleEventVO;
import com.hyomee.example35.e01.productPlan.EventSeniorPlan;
import com.hyomee.example35.e01.productPlan.ProductPlan;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class EventSoC35 {
    public BenefitVO wirelessSubscriberEvent(SaleEventVO saleEventVO) {

        // 1. 이벤트 대상자 서류 제출 여부 체크
        if (isNotEventCandiDateSubmit(saleEventVO))
            return BenefitVO.initBenefitVO("NO_SUBMIT");

        // 2. 단말기 정책 조회
        EventSeniorPlan.EVENT_MODEL_SENIOR eventModelSenior = getEventModelSenior(saleEventVO);
        if (eventModelSenior == null )
            return BenefitVO.initBenefitVO("NO_MODEL_PLAN");

        // 3. 단말기 조건 체크
        if (isNotModelPlanCheck( saleEventVO, eventModelSenior))
            return BenefitVO.initBenefitVO("NO_DEVICE");


        // 4. 60,000원 이상 요금제 가입자 체크
        if (isNotProductPlanCheck(saleEventVO))
            return BenefitVO.initBenefitVO("NO_PROD");


        // 5. 정책 조회
        EventSeniorPlan.EVENT_BENEFIT_SENIOR eventBenefitSenior =  getBenefit();
        if (eventBenefitSenior == null)
            return BenefitVO.initBenefitVO("NO_PLAN");

        // 6 정책 반영
        return BenefitVO.builder()
                .reason("")
                .productCode(eventBenefitSenior.getAddProductCode())
                .devicePrice(saleEventVO.getDevicePrice() - eventBenefitSenior.getDeviceDcPrice())
                .build();

    }


    /**
     * 1. 이벤트 대상자 서류 제출 여부 체크
     * - 함수 추출 하기, 변수 인라인 하기 적용
     **/
    private boolean isNotEventCandiDateSubmit (SaleEventVO saleEventVO) {
        // 1. 이벤트 대상자 서류 제출 여부 체크
        return saleEventVO.isEventCandiDateSubmit() ? false : true;
    }


    /**
     * 2. 단말기 정책 조회
     * - 함수 추출 하기
     **/
    private EventSeniorPlan.EVENT_MODEL_SENIOR  getEventModelSenior (SaleEventVO saleEventVO) {
        // 2. 갤럭시 폰 이고 단말기 금액이 500,000이상 체크
        Optional<EventSeniorPlan.EVENT_MODEL_SENIOR> eventModelSeniorOptional = Arrays.stream(EventSeniorPlan.EVENT_MODEL_SENIOR.values())
                .filter(eventSeniorTmp -> eventSeniorTmp.getEventYear() == LocalDate.now().getYear())
                .findFirst();

        return eventModelSeniorOptional.isPresent() ?  eventModelSeniorOptional.get() : null ;
    }

    /**
     * 3. 갤럭시 폰 여부 채크
     * - 함수 추출 하기
     **/
    private boolean isNotModelPlanCheck(SaleEventVO saleEventVO,
                                        EventSeniorPlan.EVENT_MODEL_SENIOR eventModelSenior) {
        boolean isEventModel = eventModelSenior.getModelCds().stream()
                .anyMatch(model -> model.equals(saleEventVO.getModelNo()));

        return saleEventVO.getDevicePrice() < 500000 || !isEventModel ? true : false;
    }

    /**
     * 4. 60,000원 이상 요금제 가입자 체크
     * - 함수 추출 하기
     **/
    private boolean isNotProductPlanCheck(SaleEventVO saleEventVO) {
        Predicate<ProductPlan.PRODUCT_PRICE> isProductCondition = productPrice ->
                productPrice.getProductCode().equals(saleEventVO.getProductCode()) &&
                        productPrice.getProductPrice() >= 60000 ;


        return Arrays.stream(ProductPlan.PRODUCT_PRICE.values()).anyMatch(isProductCondition) ? false : true ;
    }

    /**
     * 4. 5. 정책 조회
     * - 함수 추출 하기
     **/
    private EventSeniorPlan.EVENT_BENEFIT_SENIOR getBenefit() {

        Optional<EventSeniorPlan.EVENT_BENEFIT_SENIOR> eventSeniorOptional = Arrays.stream(EventSeniorPlan.EVENT_BENEFIT_SENIOR.values())
                .filter(eventSeniorTmp -> eventSeniorTmp.getEventYear() == LocalDate.now().getYear())
                .findFirst();

        return eventSeniorOptional.isPresent() ? eventSeniorOptional.get() : null;

    }

}

