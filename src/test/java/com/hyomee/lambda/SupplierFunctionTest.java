package com.hyomee.lambda;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
@DisplayName("Random 테스트")
class SupplierFunctionTest {

    @Autowired
    private SupplierFunction supplierFunction;

    private List<가입자상품VO> 가입자상품목록;
    @BeforeEach
    void setUp() {
        가입자상품목록 = Arrays.asList(가입자상품VO.builder()
                        .가입자id("S1234567890")
                        .상품명("부가상품_01")
                        .build(),
                가입자상품VO.builder()
                        .가입자id("S1234567890")
                        .상품명("부가상품_02")
                        .build());
    }
    @Test
    void 부가상품_A자동추가_test() {
        가입자상품목록 = supplierFunction.부가상품_A자동추가(가입자상품목록);
        assertEquals(true, 가입자상품목록.stream().anyMatch(가입자상품V0 -> "부가상품_A".equals(가입자상품V0.get상품명())));

    }

    @Test
    void supplier_부가상품_A자동추가_test() {
        가입자상품목록 = supplierFunction.supplier_부가상품_A자동추가(가입자상품목록);
        assertEquals(true, 가입자상품목록.stream().anyMatch(가입자상품V0 -> "부가상품_A".equals(가입자상품V0.get상품명())));

    }

    @Test
    void 필요한데이터얻기 () {

        List<HashMap> 장비데이터s = List.of(new HashMap<>() {{
                                                put("숫자", 10);
                                                put("메세지", "습도:70, 온도:30");
                                            }},
                                            new HashMap<>() {{
                                                put("숫자", -10);
                                                put("메세지", "습도:70");
                                            }},
                                            new HashMap<>() {{
                                                put("숫자", -10);
                                                put("메세지", "습도:70, 온도:340");
                                            }}
                                        );
         supplierFunction.필요한데이터얻기(장비데이터s);

    }


}