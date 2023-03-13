package com.hyomee.refactoring.ecapsulate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Log4j2
public class EncapsulateCollection {

    public Map 서비스요소성성() {
        Map 상품Map = new HashMap<>();
        상품Map.put("상품코드", "요금상품");
        List<HashMap> 서비스요소목록 = 서비스요소생성();
        상품Map.put("서비스요소목록", 서비스요소목록);
        return 상품Map;
    }

    private List<HashMap> 서비스요소생성() {
        List<HashMap> 서비스요소_List = new ArrayList<>();

        // ① 서비스요소_01을 생성 한다.
        HashMap 서비스요소_01 = new HashMap();
        서비스요소_01.put("이벤트코드", "ACT");
        서비스요소_01.put("요소코드", "LZF0000001");
        서비스요소_01.put("파라메터", "F100=001002");
        서비스요소_List.add(서비스요소_01);

        // ② 서비스요소_02에 서비스요소_01를 복사한다,.
        HashMap 서비스요소_02 = 서비스요소_01;
        서비스요소_02.put("파라메터", "F100=0010023");
        서비스요소_List.add(서비스요소_02);

        return 서비스요소_List;
    }

    public Map 서비스요소성성_DeepCopy() {
        Map 상품Map = new HashMap<>();
        상품Map.put("상품코드", "요금상품");
        List<HashMap> 서비스요소목록 = 서비스요소생성_DeepCopy();
        상품Map.put("서비스요소목록", 서비스요소목록);
        return 상품Map;
    }

    private List<HashMap> 서비스요소생성_DeepCopy() {
        List<HashMap> 서비스요소_List = new ArrayList<>();

        // ① 서비스요소_01을 생성 한다.
        HashMap 서비스요소_01 = new HashMap();
        서비스요소_01.put("이벤트코드", "ACT");
        서비스요소_01.put("요소코드", "LZF0000001");
        서비스요소_01.put("파라메터", "F100=001002");
        서비스요소_List.add(서비스요소_01);

        // ② 서비스요소_02에 서비스요소_01를 복사한다,.
        HashMap 서비스요소_02 = 서비스요소_01;
        // HashMap 서비스요소_02 = (HashMap) 서비스요소_01.clone();
        서비스요소_02.put("파라메터", "F100=0010023");
        서비스요소_List.add(서비스요소_02);

        return 서비스요소_List;
    }

    public List<List<서비스요소VO>> 서비스요소성성리프랙션() {
        List<List<서비스요소VO>> 상품서비스요소목록 = new ArrayList<>();
        상품VO a상품VO = 서비스요소생성_리프랙션();

        상품서비스요소목록.add(a상품VO.get서비스요소목록());
        상품서비스요소목록.add(a상품VO.서비스요소목록전체복제());

        return 상품서비스요소목록;
    }

    private 상품VO 서비스요소생성_리프랙션() {


        // ① 서비스요소_01을 생성 한다.
        서비스요소VO 서비스요소V0_01 = 서비스요소VO.builder()
                .이벤트코드("ACT")
                .요소코드("LZF0000001")
                .파라메터("F100=001002")
                .build();

        상품VO 상품VO_01 = 상품VO.builder()
                .상품코드("요금상품")
                .build();
        상품VO_01.서비스요소목록추가(서비스요소V0_01);

        // ② 서비스요소_02에 서비스요소_01를 복사한다,.
        서비스요소VO 서비스요소V0_02 = 서비스요소VO.서비스요소복재(서비스요소V0_01);
        서비스요소V0_02.set파라메터("F100=0010023");
        상품VO_01.서비스요소목록추가(서비스요소V0_02);



        return 상품VO_01;
    }

}

@Getter
@Setter
@Builder(toBuilder = true)
class 서비스요소VO   {

    private String 이벤트코드;
    private String 요소코드;
    private String 파라메터;

    public static 서비스요소VO 서비스요소복재(서비스요소VO from서비스요소VO) {
        return from서비스요소VO.toBuilder().build();
    }
}

@Getter
@Setter
@Builder(toBuilder = true)
class 상품VO    {
    private String 상품코드;

    private List<서비스요소VO> 서비스요소목록;

    public void 서비스요소목록추가(서비스요소VO a서비스목록vo) {
        if (서비스요소목록 == null ||  서비스요소목록.size() ==0 ){
            서비스요소목록 = new ArrayList<>();
        }

        서비스요소목록.add(a서비스목록vo);
    }
    public List<서비스요소VO> 서비스요소목록전체복제() {
        return 서비스요소목록.stream()
                .map(서비스요소VO :: 서비스요소복재)
                .collect(Collectors.toList());
    }

    public void 서비스요소목록전체클리어() {
        서비스요소목록.clear();
    }

    public void 서비스요소목록행삭제(int row) {
        서비스요소목록.remove(row);
    }

    public void 서비스요소목록단건추가및뱐경(int row, 서비스요소VO p_서비스요소VO) {
        서비스요소목록.set(row, p_서비스요소VO);
    }

    public 서비스요소VO 서비스요소선택ShallowCopy(int row) {
        return  서비스요소목록.get(row);
    }

    public 서비스요소VO 서비스요소선택DeepCopy(int row) {
        return  서비스요소VO.서비스요소복재(서비스요소목록.get(row));
    }

}





