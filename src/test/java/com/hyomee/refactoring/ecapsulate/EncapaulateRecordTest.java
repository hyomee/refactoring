package com.hyomee.refactoring.ecapsulate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EncapaulateRecordTest {


    @Autowired
    private EncapaulateRecord encapaulateRecord;

    private HashMap 가입정보기대값= new HashMap();
    private 가입정보VO 가입정보VO기기대값;

    @BeforeEach
    void setUp() {
        가입정보기대값.put("가입번호", "10000000001");
        가입정보기대값.put("명의자고객번호", "90000000001");
        가입정보기대값.put("가입상태",  "A");
        가입정보기대값.put("가입일자",  LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));


        가입정보VO기기대값 = 가입정보VO.builder()
                .가입번호("10000000001")
                .명의자고객번호("90000000001")
                .가입상태("A")
                .가입일자(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                .build();
    }

    @Test
    void 가입자생성_Test() {
        HashMap 가입자정보 = encapaulateRecord.가입자생성();
        assertEquals(가입정보기대값, 가입자정보);
    }

    @Test
    void 가입자생성Encapslute_Test() {
        가입정보VO 가입자정보 = encapaulateRecord.가입자생성Encapslute();
        assertThat(가입자정보).usingRecursiveComparison().isEqualTo(가입정보VO기기대값);
    }
}
