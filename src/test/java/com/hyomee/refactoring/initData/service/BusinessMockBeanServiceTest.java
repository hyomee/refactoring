package com.hyomee.refactoring.initData.service;

import com.hyomee.refactoring.initData.dto.TbEntrAllDTO;
import com.hyomee.refactoring.initData.dto.TbSbEntrDTO;
import com.hyomee.refactoring.initData.dto.TbSbSvcByEntrDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@Log4j2
class BusinessMockBeanServiceTest {

    private final String SVC_CD =  "LZP0000001";
    private final String ENTR_STTS_CD =  "A";
    private final String SVC_STTS_CD =  "A";
    private final String ENTR_ID =  "100000000001";


    @Autowired
    private BusinessService businessService;

    @MockBean(name = "tbEntrService" )
    private TbEntrService tbEntrService;

    @SpyBean(name = "tbSvcByEntrService")
    private TbSvcByEntrService tbSvcByEntrService;


    private TbSbEntrDTO tbSbEntrDTO;
    private List<TbSbSvcByEntrDTO> tbSbSvcByEntrDTOList;

    @BeforeEach
    void beforeEach() {
        tbSbEntrDTO = TbSbEntrDTO.builder()
                .entrId(ENTR_ID)
                .svcCd(SVC_CD)
                .prodNo("010094115479")
                .entrSttsCd(ENTR_STTS_CD)
                .build();

        tbSbSvcByEntrDTOList = List.of(
                TbSbSvcByEntrDTO.builder()
                        .entrId(ENTR_ID)
                        .svcCd(SVC_CD)
                        .prodCd("LZP00000001")
                        .svcSttsCd(SVC_STTS_CD)
                        .build(),
                TbSbSvcByEntrDTO.builder()
                        .entrId(ENTR_ID)
                        .svcCd(SVC_CD)
                        .prodCd("LRP00000002")
                        .svcSttsCd(SVC_STTS_CD)
                        .build()
        );
    }



    @Test
    @DisplayName("가입자 정보 가지고 오기")
    void findByAllEntr() {

        TbEntrAllDTO tbEntrAllDTOOrg = TbEntrAllDTO.builder()
                .tbSbEntrDTO(tbSbEntrDTO)
                .tbSbSvcByEntrDTOList(tbSbSvcByEntrDTOList)
                .build();

        given(tbEntrService.findByEntr(ENTR_ID)).willReturn(tbSbEntrDTO);
        given(tbSvcByEntrService.findProdByEntrid(ENTR_ID)).willReturn(tbSbSvcByEntrDTOList);
        TbEntrAllDTO tbEntrAllDTO = businessService.findByAllEntr(ENTR_ID);
        assertEquals(tbEntrAllDTOOrg, tbEntrAllDTO);

    }
}