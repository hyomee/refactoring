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
public class Event35 {

    public BenefitVO wirelessSubscriberEvent(SaleEventVO saleEventVO) {


        // 1. 이벤트 대상자 서류 제출 여부 체크
        if (!saleEventVO.isEventCandiDateSubmit()) {
            return BenefitVO.initBenefitVO("NO_SUBMIT");
        }

        // 2. 갤럭시 폰 이고 단말기 금액이 500,000이상 체크
        Optional<EventSeniorPlan.EVENT_MODEL_SENIOR> eventModelSeniorOptional = Arrays.stream(EventSeniorPlan.EVENT_MODEL_SENIOR.values())
                .filter(eventSeniorTmp -> eventSeniorTmp.getEventYear() == LocalDate.now().getYear())
                .findFirst();

        if (!eventModelSeniorOptional.isPresent()) {
            return BenefitVO.initBenefitVO("NO_MODEL_PLAN");
        }

        boolean isEventModel = eventModelSeniorOptional.get().getModelCds().stream()
                .anyMatch(model -> model.equals(saleEventVO.getModelNo()));

        if (saleEventVO.getDevicePrice() < 500000 || !isEventModel) {
            return BenefitVO.initBenefitVO("NO_DEVICE");
        }

        // 3. 60,000원 이상 요금제 가입자 체크
        Predicate<ProductPlan.PRODUCT_PRICE> isProductCondition = productPrice ->
                productPrice.getProductCode().equals(saleEventVO.getProductCode()) &&
                        productPrice.getProductPrice() >= 60000 ;


        if (!Arrays.stream(ProductPlan.PRODUCT_PRICE.values()).anyMatch(isProductCondition)) {
            return BenefitVO.initBenefitVO("NO_PROD");
        }

        // 4. 정책 조회
        Optional<EventSeniorPlan.EVENT_BENEFIT_SENIOR> eventSeniorOptional = Arrays.stream(EventSeniorPlan.EVENT_BENEFIT_SENIOR.values())
                .filter(eventSeniorTmp -> eventSeniorTmp.getEventYear() == LocalDate.now().getYear())
                .findFirst();

        if (! eventSeniorOptional.isPresent())    {
            return BenefitVO.initBenefitVO("NO_PLAN");
        }

        EventSeniorPlan.EVENT_BENEFIT_SENIOR eventSenior = eventSeniorOptional.get();

        // 6 정책 반영
        return BenefitVO.builder()
                .reason("")
                .productCode(eventSenior.getAddProductCode())
                .devicePrice(saleEventVO.getDevicePrice() - eventSenior.getDeviceDcPrice())
                .build();

    }
}

