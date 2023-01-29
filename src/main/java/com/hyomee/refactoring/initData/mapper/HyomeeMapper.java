package com.hyomee.refactoring.initData.mapper;

import com.hyomee.refactoring.initData.dto.TbSbEntrDTO;
import com.hyomee.refactoring.initData.dto.TbSbSvcByEntrDTO;
import com.hyomee.refactoring.initData.entity.TbSbEntr;
import com.hyomee.refactoring.initData.entity.TbSbSvcByEntr;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HyomeeMapper {

    HyomeeMapper INSTANCE = Mappers.getMapper(HyomeeMapper.class);

    List<TbSbEntr> toTbSbEntrList(List<TbSbEntrDTO> tbSbEntrList);
    TbSbEntr toTbSbEntr(TbSbEntrDTO tbSbEntrDTO);

    List<TbSbEntrDTO> toTbSbEntrDTOList(List<TbSbEntr> tbSbEntrList);

    TbSbEntrDTO toTbSbEntrDTO(TbSbEntr tbSbEntr);


    List<TbSbSvcByEntr> toTbSbSvcByEntrList(List<TbSbSvcByEntrDTO> tbSbSvcByEntrDTOList);
    TbSbSvcByEntr toTbSbSvcByEntr(TbSbSvcByEntrDTO tbSbSvcByEntrDTO);

    List<TbSbSvcByEntrDTO> toTbSbSvcByEntrDTOList(List<TbSbSvcByEntr> tbSbSvcByEntrList);
    TbSbSvcByEntrDTO toTbSbSvcByEntrDTO(TbSbSvcByEntr tbSbSvcByEntr);

}
