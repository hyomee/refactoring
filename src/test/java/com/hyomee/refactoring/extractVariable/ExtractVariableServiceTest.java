package com.hyomee.refactoring.extractVariable;

import com.hyomee.refactoring.initData.dto.TbEntrDevSaleDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Log4j2
class ExtractVariableServiceTest {

    @Autowired
    private ExtractVariableService extractVariableService;

    private TbEntrDevSaleDTO tbEntrDevSaleDTO;

    @BeforeEach
    void beforeEach() {
        tbEntrDevSaleDTO = TbEntrDevSaleDTO.builder()
                .entrId("100000000")
                .mdlCd("APPLE_0001")
                .salePolicyCd("BASE_POLICY")
                .contractPolicyCd("CONTRACT_POLICY")
                .yearsOfuse(0)
                .build();
    }


    @Test
    @DisplayName("ExtractVariable! .... ")
    void mobilePhoneSellingPrice() {

        double lastPrice = extractVariableService.mobilePhoneSellingPrice(tbEntrDevSaleDTO);
        assertThat(1500000.0).isEqualTo(lastPrice);
    }

    @Test
    @DisplayName("ExtractVariable Refacting! .... ")
    void mobilePhoneSellingPriceRefacting() {

        double lastPrice = extractVariableService.mobilePhoneSellingPriceRefactoring(tbEntrDevSaleDTO);
        log.debug( String.format("기대값 %f , 처리 값 %f",  1500000.0, lastPrice) );
        assertThat(1500000.0).isEqualTo(lastPrice);
    }
}