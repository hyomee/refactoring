package com.hyomee.refactoring.initData.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TbSbEntrDTO {

    private Long id;
    private String entrId;
    private String svcCd;
    private String prodNo;
    private String entrSttsCd;




}
