package com.hyomee.refactoring.capsulate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EncapsulateCollectionTest {

    @Autowired
    EncapsulateCollection encapsulateCollection;


    @Test
    void 복수가입자생성_TEST() {
        List<HashMap> 가입자정보List =  encapsulateCollection.복수가입자생성();
        HashMap 가입자정보01 = 가입자정보List.get(0);
        HashMap 가입자정보02= 가입자정보List.get(1);
        assertThat(가입자정보01).usingRecursiveComparison().isNotEqualTo(가입자정보02);
    }


}



