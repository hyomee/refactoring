package com.hyomee.refactoring.initData.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="TB_SB_SVC_BY_ENTR")
public class TbSbSvcByEntr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Long id;

    @Column(name = "SVC_CD", nullable = false, length = 10)
    private String svcCd;
    @Column(name = "ENTR_ID", nullable = false, length = 12)
    private String entrId;

    @Column(name = "PROD_CD", nullable = false, length = 10)
    private String prodCd;
    @Column(name = "SVC_STTS_CD", nullable = false, length = 1)
    private String svcSttsCd;

}
