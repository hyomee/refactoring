package com.hyomee.refactoring.initData.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TbSbSvcByEntrDTO {
    private Long id;
    private String svcCd;
    private String entrId;
    private String prodCd;
    private String svcSttsCd;
}
