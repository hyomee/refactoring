package com.hyomee.refactoring.initData.mapper;

import com.hyomee.refactoring.initData.dto.TbSbEntrDTO;
import com.hyomee.refactoring.initData.entity.TbSbEntr;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HyomeeMapper {

    HyomeeMapper INSTANCE = Mappers.getMapper(HyomeeMapper.class);

    List<TbSbEntr> toTbSbEntrList(List<TbSbEntrDTO> tbSbEntrList);
    TbSbEntr toTbSbEntr(TbSbEntrDTO tbSbEntrDTO);

    List<TbSbEntrDTO> toTbSbEntrDTOList(List<TbSbEntr> tbSbEntrList);
    TbSbEntrDTO toTbSbEntr(TbSbEntr tbSbEntr);


}
