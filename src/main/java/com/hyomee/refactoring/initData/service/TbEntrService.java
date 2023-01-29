package com.hyomee.refactoring.initData.service;

import com.hyomee.refactoring.initData.dto.TbSbEntrDTO;
import com.hyomee.refactoring.initData.entity.TbSbEntr;
import com.hyomee.refactoring.initData.mapper.HyomeeMapper;
import com.hyomee.refactoring.initData.repository.TbSbEntrRespository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor // final 로 선언된 것 만 생성
@Log4j2
public class TbEntrService {

    private final TbSbEntrRespository tbSbEntrRespository;


    public List<TbSbEntrDTO> saveTbSbEntr(List<TbSbEntrDTO> tbSbEntrDTOList) {


        List<TbSbEntrDTO> tbSbEntrDTORn = new LinkedList<>();
        List<TbSbEntrDTO> saveTbSbEntrDTOList = new LinkedList<>();

        // 동일 정보 존재 여부 체크
        for ( TbSbEntrDTO tbSbEntrDTO : tbSbEntrDTOList) {
            int entrCnt = tbSbEntrRespository.countByEntrIdAndProdNo(tbSbEntrDTO.getEntrId(), tbSbEntrDTO.getProdNo());
            if ( entrCnt == 0 ) {
                saveTbSbEntrDTOList.add(tbSbEntrDTO);
            }
        }

        if (saveTbSbEntrDTOList.size() > 0) {
            List<TbSbEntr> tbSbEntrList = HyomeeMapper.INSTANCE.toTbSbEntrList(tbSbEntrDTOList);
            List<TbSbEntr> tbSbEntrListRn = tbSbEntrRespository.saveAll(tbSbEntrList);
            tbSbEntrDTORn =  HyomeeMapper.INSTANCE.toTbSbEntrDTOList(tbSbEntrListRn);
        }

        return tbSbEntrDTORn;
    }

    public TbSbEntrDTO findByEntr(String entrId) {
        TbSbEntr tbSbEntr = tbSbEntrRespository.findByEntrId(entrId);
        return HyomeeMapper.INSTANCE.toTbSbEntrDTO(tbSbEntr);
    }
}
