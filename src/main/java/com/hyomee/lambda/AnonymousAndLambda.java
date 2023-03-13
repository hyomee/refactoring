package com.hyomee.lambda;

import org.springframework.stereotype.Service;


public class AnonymousAndLambda {

    public static void main(String[] args) {
        익명과람다();
    }
    public static void 익명과람다() {

        // 익명함수
        Runnable 실행익명 = new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 클래스...");
            }
        };

        Runnable 실행람다 = ()->System.out.println("람다");

        실행(실행익명);
        실행(실행람다);
        실행(()->System.out.println("람다 2"));

    }

    public static void 실행(Runnable 실핼) {
        실핼.run();
    }
}
