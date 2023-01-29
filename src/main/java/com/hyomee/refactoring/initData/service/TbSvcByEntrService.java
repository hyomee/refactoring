package com.hyomee.refactoring.initData.service;

import com.hyomee.refactoring.initData.dto.TbSbSvcByEntrDTO;
import com.hyomee.refactoring.initData.mapper.HyomeeMapper;
import com.hyomee.refactoring.initData.repository.TbSbSvcByEntrRespositoy;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // final 로 선언된 것 만 생성
@Log4j2
public class TbSvcByEntrService {

    private final TbSbSvcByEntrRespositoy tbSbSvcByEntrRespositoy;
    public List<TbSbSvcByEntrDTO> findProdByEntrid(String entrId) {

        return HyomeeMapper.INSTANCE.toTbSbSvcByEntrDTOList(tbSbSvcByEntrRespositoy.findByEntrId(entrId));

    }
}
