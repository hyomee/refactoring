package com.hyomee.refactoring.ecapsulate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Log4j2
public class EncapaulateRecord {

    public HashMap 가입자생성() {
        HashMap 가입정보단수 = 가입자정보단건생성();

        if (!가입정보단수.containsKey("가입일자") && StringUtils.isEmpty((CharSequence) 가입정보단수.get("가입일자"))) {
            가입정보단수.put("가입일자",   LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        }
        // .... 로직 .....

        return 가입정보단수;
    }





    public 가입정보VO 가입자생성Encapslute() {
        가입정보VO 가입정보단수VO =  가입자정보단건생성Encapslute();

        if (StringUtils.isEmpty(가입정보단수VO.get가입일자())) {
            가입정보단수VO.set가입일자(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        }
        // .... 로직 .....

        return 가입정보단수VO;
    }
    private 가입정보VO 가입자정보단건생성Encapslute() {
        return 가입정보VO.builder()
                .가입번호("10000000001")
                .명의자고객번호("90000000001")
                .가입상태("A")
                .build();
    }

    private HashMap 가입자정보단건생성() {
        HashMap 가입자정보Map = new HashMap();
        가입자정보Map.put("가입번호", "10000000001");
        가입자정보Map.put("명의자고객번호", "90000000001");
        가입자정보Map.put("가입상태",  "A");
        return 가입자정보Map;
    }

    private List<HashMap> 가입자정보생성복수생성() {
        List<HashMap> 가입정보List = new ArrayList<>();

        HashMap 가입자정보Map = new HashMap();
        가입자정보Map.put("가입번호", "10000000001");
        가입자정보Map.put("명의자고객번호", "90000000001");
        가입자정보Map.put("가입상태",  "A");
        가입자정보Map.put("가입일자",  "20230201");
        가입정보List.add(가입자정보Map);

        // ... 로직

        HashMap 가입자정보Map01 = new HashMap();
        가입자정보Map.put("가입번호", "10000000002");
        가입자정보Map.put("명의자고객번호", "90000000002");
        가입자정보Map.put("가입상태",  "A");
        가입정보List.add(가입자정보Map);

        return 가입정보List;
    }

}

@Getter
@Setter
@Builder
class 가입정보VO {
    private String 가입번호;
    private String 명의자고객번호;
    private String 가입상태;
    private String 가입일자;

}
