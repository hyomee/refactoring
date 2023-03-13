package com.hyomee.example35.e01.productPlan;

import com.hyomee.example35.e01.event.vo.SaleEventVO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@Service
public class PlanService {

    public EventSeniorPlan.EVENT_MODEL_SENIOR  getEventModelSenior (SaleEventVO saleEventVO) {
        // 2. 갤럭시 폰 이고 단말기 금액이 500,000이상 체크
        Optional<EventSeniorPlan.EVENT_MODEL_SENIOR> eventModelSeniorOptional = Arrays.stream(EventSeniorPlan.EVENT_MODEL_SENIOR.values())
                .filter(eventSeniorTmp -> eventSeniorTmp.getEventYear() == LocalDate.now().getYear())
                .findFirst();

        return eventModelSeniorOptional.isPresent() ?  eventModelSeniorOptional.get() : null ;
    }

    /**
     * 4. 5. 정책 조회
     * - 함수 추출 하기
     **/
    public EventSeniorPlan.EVENT_BENEFIT_SENIOR getBenefit() {

        Optional<EventSeniorPlan.EVENT_BENEFIT_SENIOR> eventSeniorOptional = Arrays.stream(EventSeniorPlan.EVENT_BENEFIT_SENIOR.values())
                .filter(eventSeniorTmp -> eventSeniorTmp.getEventYear() == LocalDate.now().getYear())
                .findFirst();

        return eventSeniorOptional.isPresent() ? eventSeniorOptional.get() : null;
    }
}
