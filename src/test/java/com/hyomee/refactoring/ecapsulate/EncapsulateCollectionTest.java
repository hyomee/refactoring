package com.hyomee.refactoring.ecapsulate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EncapsulateCollectionTest {

    @Autowired
    EncapsulateCollection encapsulateCollection;


    @Test
    void 서비스요소생성_테스트() {
        Map 상품Map =  encapsulateCollection.서비스요소성성();
        HashMap 서비스요소_01 = ((List<HashMap> ) 상품Map.get("서비스요소목록")).get(0);
        HashMap 서비스요소_02 = ((List<HashMap> ) 상품Map.get("서비스요소목록")).get(1);

        서비스요소_02.put("이벤트코드", "DEL");
        assertThat(서비스요소_01).usingRecursiveComparison().isNotEqualTo(서비스요소_02);
    }

    @Test
    void 서비스요소성성_DeepCopy성_테스트() {
        Map 상품Map =  encapsulateCollection.서비스요소성성();
        HashMap 서비스요소_01 = ((List<HashMap> ) 상품Map.get("서비스요소목록")).get(0);
        HashMap 서비스요소_02 = ((List<HashMap> ) 상품Map.get("서비스요소목록")).get(1);
        서비스요소_02.put("이벤트코드", "DEL");
        assertThat(서비스요소_01).usingRecursiveComparison().isNotEqualTo(서비스요소_02);
    }


    @Test
    void 서비스요소성성리프랙션_테스트() {
        List<List<서비스요소VO>> 상품서비스요소목록 =  encapsulateCollection.서비스요소성성리프랙션();
        List<서비스요소VO> 상품서비스요소_01 = 상품서비스요소목록.get(0);
        List<서비스요소VO> 상품서비스요소_02 = 상품서비스요소목록.get(1);
        assertThat(상품서비스요소_01).usingRecursiveComparison().isEqualTo(상품서비스요소_02);

        서비스요소VO 서비스요소_01 = 상품서비스요소_01.get(0);
        서비스요소VO 서비스요소_02 = 상품서비스요소_02.get(1);
        서비스요소_02.set이벤트코드("DEL");
        assertThat(상품서비스요소_01).usingRecursiveComparison().isNotEqualTo(상품서비스요소_02);
    }


}



