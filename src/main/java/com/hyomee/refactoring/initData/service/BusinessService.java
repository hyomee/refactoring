package com.hyomee.refactoring.initData.service;

import com.hyomee.refactoring.initData.dto.TbEntrAllDTO;
import com.hyomee.refactoring.initData.dto.TbSbEntrDTO;
import com.hyomee.refactoring.initData.dto.TbSbSvcByEntrDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final 로 선언된 것 만 생성
@Service

@Log4j2
public class BusinessService  {

    private final TbEntrService tbEntrService;
    private final TbSvcByEntrService tbSvcByEntrService;

    public TbEntrAllDTO findByAllEntr(String entrId) {

        TbSbEntrDTO tbSbEntrDTO = tbEntrService.findByEntr(entrId);
        List<TbSbSvcByEntrDTO> tbSbSvcByEntrDTOList = tbSvcByEntrService.findProdByEntrid(entrId);

        return TbEntrAllDTO.builder()
                .tbSbEntrDTO(tbSbEntrDTO)
                .tbSbSvcByEntrDTOList(tbSbSvcByEntrDTOList)
                .build();

    }
}
