package com.hyomee.refactoring.initData.entity;

import com.hyomee.refactoring.initData.dto.TbSbEntrDTO;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
@Table(name="TB_SB_ENTR")
public class TbSbEntr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Long id;
    @Column(name = "ENTR_ID", nullable = false, length = 12)
    private String entrId;

    @Column(name = "SVC_CD", nullable = false, length = 10)
    private String svcCd;
    @Column(name = "PROD_NO", nullable = false, length = 12)
    private String prodNo;
    @Column(name = "ENTR_STTS_CD", nullable = false, length = 1)
    private String entrSttsCd;

    @Column(name = "HLDR_CUST_NO",   length = 12)
    private String hldrCustNo;



}
