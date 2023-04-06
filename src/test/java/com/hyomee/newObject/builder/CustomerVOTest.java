package com.hyomee.newObject.builder;

import com.hyomee.newObject.builder.base.CustomerVO;
import com.hyomee.newObject.builder.base.CutomerBuilder;
import org.junit.jupiter.api.Test;

class CustomerVOTest {

    @Test
    void createCustomerVO() {
        CustomerVO builder = new CutomerBuilder()
                .division("개인")
                .name("홍길동")
                .age("24")
                .identificationNo("901022342456")
                .build();


        CustomerVO builder01 = new CutomerBuilder()
                .division("개인")
                .name("홍길동")
                .age("24")
                .sex("남자")
                .identificationNo("801022342456")
                .build();

        CustomerVO builder02 = new CutomerBuilder()
                .division("법인")
                .name("주식회사A")
                .age("24")
                .identificationNo("1234561023843")
                .businessNo("1234512345")
                .build();


        CustomerVO builder03 = new CutomerBuilder()
                .division("법인")
                .name("주식회사A")
                .age("24")
                .identificationNo("6543211023843")
                .businessNo("9870623123")
                .build();

        System.out.println(builder.toString());
    }
}