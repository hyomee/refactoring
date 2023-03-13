package com.hyomee.refactoring;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CopyMapper {
    CopyMapper copyMapper =  Mappers.getMapper(CopyMapper.class);
    SvcFtrVO toSvcFtrVO(SvcFtrVO fromSvcFtrVO);
}


