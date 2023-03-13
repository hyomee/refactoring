package com.hyomee.example35.e01.productPlan;

import com.hyomee.example35.e01.event.vo.BenefitVO;
import com.hyomee.example35.e01.event.vo.SaleEventVO;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class ValidationPlanService {

    private final PlanService planService;

    @Getter
    @AllArgsConstructor
    public final class PolicyVO {
        private final BenefitVO benefitVO;
        private final EventSeniorPlan.EVENT_BENEFIT_SENIOR eventBenefit;
        private final EventSeniorPlan.EVENT_MODEL_SENIOR eventModelSenio;

    }


    public PolicyVO validationPolicy(SaleEventVO saleEventVO) {

        // 1. 정책 조회
        EventSeniorPlan.EVENT_BENEFIT_SENIOR eventBenefit =  planService.getBenefit();
        if (eventBenefit == null)
            return new PolicyVO(BenefitVO.initBenefitVO("NO_PLAN"), null, null);

        // 2. 단말기 정책 조회
        EventSeniorPlan.EVENT_MODEL_SENIOR eventModelSenior = planService.getEventModelSenior(saleEventVO);
        if (eventModelSenior == null ) {
            return new PolicyVO(BenefitVO.initBenefitVO("NO_MODEL_PLAN"), null, null);
        }

        return new PolicyVO(BenefitVO.initBenefitVO(""), eventBenefit, eventModelSenior);

    }

    public BenefitVO validationPlan(SaleEventVO saleEventVO,
                                    EventSeniorPlan.EVENT_MODEL_SENIOR eventModelSenior) {
        // 1. 이벤트 대상자 서류 제출 여부 체크
        if (isNotEventCandiDateSubmit(saleEventVO))
            return BenefitVO.initBenefitVO("NO_SUBMIT");

        // 2. 단말기 조건 체크
        if (isNotModelPlanCheck( saleEventVO, eventModelSenior))
            return BenefitVO.initBenefitVO("NO_DEVICE");

        // 3. 60,000원 이상 요금제 가입자 체크
        if (isNotProductPlanCheck(saleEventVO))
            return BenefitVO.initBenefitVO("NO_PROD");

        return BenefitVO.initBenefitVO("");
    }



    // 이벤트 대상자 서류 체크
    private boolean isNotEventCandiDateSubmit (SaleEventVO saleEventVO) {
        return saleEventVO.isEventCandiDateSubmit() ? false : true;
    }

    // 갤럭시 폰 이고 단말기 금액이 500,000이상 체크
    private boolean isNotModelPlanCheck(SaleEventVO saleEventVO,
                                        EventSeniorPlan.EVENT_MODEL_SENIOR eventModelSenior) {
        boolean isEventModel = eventModelSenior.getModelCds().stream()
                .anyMatch(model -> model.equals(saleEventVO.getModelNo()));

        return saleEventVO.getDevicePrice() < 500000 || !isEventModel ? true : false;
    }

    // 60,000원 이상 요금제 가입자 체크
    private boolean isNotProductPlanCheck(SaleEventVO saleEventVO) {
        Predicate<ProductPlan.PRODUCT_PRICE> isProductCondition = productPrice ->
                productPrice.getProductCode().equals(saleEventVO.getProductCode()) &&
                        productPrice.getProductPrice() >= 60000 ;


        return Arrays.stream(ProductPlan.PRODUCT_PRICE.values()).anyMatch(isProductCondition) ? false : true ;
    }
}
