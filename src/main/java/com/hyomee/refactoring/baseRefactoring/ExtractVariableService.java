package com.hyomee.refactoring.baseRefactoring;

import com.hyomee.refactoring.initData.dto.TbEntrDevSaleDTO;
import com.hyomee.refactoring.initData.policy.DevContractPolicy;
import com.hyomee.refactoring.initData.policy.DevSalePolicy;
import com.hyomee.refactoring.initData.policy.DevSalePrice;
import org.springframework.stereotype.Service;

@Service
public class ExtractVariableService {

    /**
     * 핸드폰 판매 가격은 판매 가격 - 정책 할인 가격 - 약정개월 수 할인 - 고객사용 연수
     * 정책 할인 ( 기본 정책 : 0, 픅판 1 정책 : -100,000, 픅판 2 정책 : -200,000 )
     * 약정 할인 ( 기본 정책 : 0, 12개월 : -100,000, 24개월 : -200,000 , 36 개월 : -300,000 )
     * 사용 년수 ( 기본 정책 : 0, 1년당 : -10,000  ( 1년당 : 10000) )
     */
    public Double mobilePhoneSellingPrice(TbEntrDevSaleDTO tbEntrDevSaleDTO) {
        return DevSalePrice.valueOf(tbEntrDevSaleDTO.getMdlCd()).getPrice()
                - DevSalePolicy.valueOf(tbEntrDevSaleDTO.getSalePolicyCd()).getSalePolicyDcPrice()
                - DevContractPolicy.valueOf(tbEntrDevSaleDTO.getContractPolicyCd()).getContractPolicyDcPrice()
                - (( tbEntrDevSaleDTO.getYearsOfuse() / 10 ) * 10000);
    }

    public Double mobilePhoneSellingPriceRefactoring(TbEntrDevSaleDTO tbEntrDevSaleDTO) {

        double mdlPrice = DevSalePrice.valueOf(tbEntrDevSaleDTO.getMdlCd()).getPrice();
        double devSalePolicyDcPrice = DevSalePolicy.valueOf(tbEntrDevSaleDTO.getSalePolicyCd()).getSalePolicyDcPrice();
        double devContractPolicyDcPrice = DevContractPolicy.valueOf(tbEntrDevSaleDTO.getContractPolicyCd()).getContractPolicyDcPrice();
        double yearsOfUseDcPrice = (( tbEntrDevSaleDTO.getYearsOfuse() / 10 ) * 10000);

        return mdlPrice - devSalePolicyDcPrice - devContractPolicyDcPrice - yearsOfUseDcPrice;
    }
}
