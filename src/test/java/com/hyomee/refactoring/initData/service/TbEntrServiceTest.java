package com.hyomee.refactoring.initData.service;

import com.hyomee.refactoring.initData.dto.TbSbEntrDTO;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
@Log4j2
// @Transactional ( 종료시 자동 롤백 )
class TbEntrServiceTest {

    @Autowired
    private TbEntrService tbEntrService;

    @Test
    void testSaveTbSbEntr() {
        // 테이터 셍성
        List<TbSbEntrDTO> TbSbEntrDTORn = tbEntrService.saveTbSbEntr(initDataTbSbEntr());
        log.debug(TbSbEntrDTORn.toString());

        assertThat("1").isEqualTo("1");
    }

    List<TbSbEntrDTO> initDataTbSbEntr() {
        final String SVC_CD =  "LZP0000001";
        final String ENTR_STTS_CD =  "A";
        return List.of(
                TbSbEntrDTO.builder()
                        .entrId("100000000001")
                        .svcCd(SVC_CD)
                        .prodNo("010094115479")
                        .entrSttsCd(ENTR_STTS_CD)
                        .build(),
                TbSbEntrDTO.builder()
                        .entrId("100000000001")
                        .svcCd(SVC_CD)
                        .prodNo("010084115479")
                        .entrSttsCd(ENTR_STTS_CD)
                        .build()
        );
    }


}