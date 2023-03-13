package com.hyomee.refactoring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShallowDeepCopyTest {

    @Autowired
    ShallowDeepCopy shallowDeepCopy;

    @Test
    void shallowCopy() {
        shallowDeepCopy.ObjectCopy();
    }

    @Test
    void mapStructCopy() {
        shallowDeepCopy.MapStructCopy();
    }
}