package com.hyomee.refactoring.addAssert;

import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class AddAssert {
    public int 요금계산(고객정보VO a고객정보VO) throws Exception {
        if (a고객정보VO != null || StringUtils.isEmpty(a고객정보VO.get고겍요금제())) {
            throw new Exception("요금제 필수 입니다.");
        }
        return get요율By요금제(a고객정보VO.get고겍요금제());
    }

    public int asserT요금계산(고객정보VO a고객정보VO)   {
        assert a고객정보VO == null || StringUtils.isNotEmpty(a고객정보VO.get고겍요금제()) : "요금제 필수 입니다." ;
        log.debug(".... ???? ");
        return get요율By요금제(a고객정보VO.get고겍요금제());
    }

    private int get요율By요금제(String 요금제) {
        // 요율 구하기
        return 1000;
    }
}


@Data
@Builder
class 고객정보VO {
    private String 고객번호;
    private String 고겍요금제;
    private String 회원구분;

}