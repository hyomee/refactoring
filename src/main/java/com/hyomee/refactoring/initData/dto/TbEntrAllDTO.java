package com.hyomee.refactoring.initData.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TbEntrAllDTO {

    private TbSbEntrDTO tbSbEntrDTO;
    private List<TbSbSvcByEntrDTO> tbSbSvcByEntrDTOList;
}
