package com.hyomee.refactoring.initData.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TbEntrDevSaleDTO {


    private String entrId;              // 가입번호
    private String mdlCd;               // 구매 모델
    private String salePolicyCd ;       // 선택 정책
    private String contractPolicyCd ;   // 약정 정책

    private int yearsOfuse;             // 사용 년수

}
