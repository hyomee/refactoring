package com.hyomee.refactoring.capsulate;

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
public class EncapsulateCollection {

    public List<HashMap> 복수가입자생성() {
       // List<HashMap> 가입정보복수 = 가입자정보생성복수생성();

        // .... 로직 .....
        return 가입자정보생성복수생성Clone();
    }

    private List<HashMap> 가입자정보생성복수생성() {
        List<HashMap> 가입정보List = new ArrayList<>();

        HashMap 가입자정보Map = new HashMap();
        가입자정보Map.put("가입번호", "10000000001");
        가입자정보Map.put("명의자고객번호", "90000000001");
        가입자정보Map.put("가입상태", "A");
        가입자정보Map.put("가입일자", "20230201");
        가입정보List.add(가입자정보Map);

        // ... 로직

        HashMap 가입자정보Map01 = 가입자정보Map;
        가입자정보Map01.put("가입번호", "10000000002");
        가입자정보Map01.put("명의자고객번호", "90000000002");
        가입자정보Map01.put("가입상태", "A");
        가입자정보Map01.put("가입일자", "20230202");
        가입정보List.add(가입자정보Map01);

        log.debug(가입자정보Map.toString());
        log.debug(가입자정보Map01.toString());

        return 가입정보List;
    }

    private List<HashMap> 가입자정보생성복수생성Clone() {
        List<HashMap> 가입정보List = new ArrayList<>();

        HashMap 가입자정보Map = new HashMap();
        가입자정보Map.put("가입번호", "10000000001");
        가입자정보Map.put("명의자고객번호", "90000000001");
        가입자정보Map.put("가입상태", "A");
        가입자정보Map.put("가입일자", "20230201");
        가입정보List.add(가입자정보Map);

        // ... 로직

        HashMap 가입자정보Map01 = (HashMap) 가입자정보Map.clone();
        가입자정보Map01.put("가입번호", "10000000002");
        가입자정보Map01.put("명의자고객번호", "90000000002");
        가입자정보Map01.put("가입상태", "A");
        가입자정보Map01.put("가입일자", "20230202");
        가입정보List.add(가입자정보Map01);



        return 가입정보List;
    }
}


@Getter
@Setter
@Builder
class 가입정보DTO   {
    private String 가입번호;
    private String 명의자고객번호;
    private String 가입상태;
    private String 가입일자;

}


@Setter
@Builder
class 가입정보DTOS implements Cloneable{
    List<가입정보DTO> 가입정보DTOs;

    public List<가입정보VO> clone() throws CloneNotSupportedException {
        가입정보VO a가입정보VO = (가입정보VO) super.clone();
        return (List<가입정보VO>) super.clone();
    }

}
