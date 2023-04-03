package com.hyomee.example35.e01.event;

import com.hyomee.example35.e01.event.vo.BenefitVO;
import com.hyomee.example35.e01.event.vo.SaleEventVO;
import com.hyomee.example35.e01.productPlan.EventSeniorPlan;
import com.hyomee.example35.e01.productPlan.PlanService;
import com.hyomee.example35.e01.productPlan.ProductPlan;
import com.hyomee.example35.e01.productPlan.ValidationPlanService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class EventSoCGroup35 {

    private final ValidationPlanService validationPlanService;

    public BenefitVO wirelessSubscriberEvent(SaleEventVO saleEventVO) {

        ValidationPlanService.PolicyVO policyVO = validationPlanService.validationPolicy(saleEventVO);
        if (StringUtils.isNotEmpty(policyVO.getBenefitVO().getReason())) {
            BenefitVO benefitVO = policyVO.getBenefitVO().toBuilder().build();
            policyVO = null; // 내부 비정적 클래스는 메모리 누수 발행할 수 있으므로 null 초가화 한다,
            return benefitVO;
        }

        String addProductCode =  policyVO.getEventBenefit().getAddProductCode();
        int deviceDcPrice = policyVO.getEventBenefit().getDeviceDcPrice();
        // 3. 혜택 조건 체크
        BenefitVO benefitVO = validationPlanService.validationPlan(saleEventVO, policyVO.getEventModelSenio());
        //policyVO = null; // 내부 비정적 클래스는 메모리 누수 발행할 수 있으므로 null 초가화 한다,
        //System.gc();
        // 4 정책 반영
        return StringUtils.isEmpty(benefitVO.getReason()) ?
                BenefitVO.builder()
                         .reason("")
                         .productCode(addProductCode)
                         .devicePrice(saleEventVO.getDevicePrice() - deviceDcPrice)
                         .build() :
                benefitVO ;
    }
}
