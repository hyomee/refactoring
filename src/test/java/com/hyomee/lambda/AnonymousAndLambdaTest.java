package com.hyomee.lambda;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AnonymousAndLambdaTest {

    @Autowired
    AnonymousAndLambda anonymousAndLambda;
    @Test
    void 익명과람다() {
        anonymousAndLambda.익명과람다();
    }
}