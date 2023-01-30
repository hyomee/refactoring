package com.hyomee.refactoring.baseRefactoring;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class EncapsulateVariableTest {

    @Autowired
    EncapsulateVariable encapsulateVariable;

    @Test
    void 고객생성() {
        encapsulateVariable.고객생성("홀길동", 10);
    }

    @Test
    void 고객생성캡슐화() {
        encapsulateVariable.고객생성캡슐화("홀길동", 30);
    }
}