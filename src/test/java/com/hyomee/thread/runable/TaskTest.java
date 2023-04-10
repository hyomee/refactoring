package com.hyomee.thread.runable;

import com.hyomee.thread.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    @DisplayName("일반 함수 호출")
    void run() {
        Runnable tesk = new Task();
        Thread thread01 = new Thread(tesk);
        Thread thread02= new Thread(tesk);
        thread01.run();
        thread02.run();
    }
    @Test
    @DisplayName("멀티 쓰레드 ")
    void start() {
        Runnable tesk = new Task();
        Thread thread01 = new Thread(tesk);
        Thread thread02= new Thread(tesk);
        thread01.start();
        thread02.start();
    }

    @Test
    @DisplayName("일반 함수 호출/멀티 쓰레드 ")
    void runAndstart() {
        Runnable tesk = new Task();
        Thread thread01 = new Thread(tesk);
        Thread thread02= new Thread(tesk);
        thread01.run();
        thread01.run();
        thread02.start();
        thread02.start();
    }

    @Test
    @DisplayName("익명 클래스를 이용한 쓰레드 ")
    void anonymousClass() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                int sum = 0 ;
                for ( int i = 0 ; i < 10; i++){
                    sum += i;
                }
                System.out.println(Thread.currentThread()  + " :: " + sum);
            }
        };

        Thread thread01 = new Thread(task);
        Thread thread02= new Thread(task);
        thread01.start();
        thread02.start();
    }

    @Test
    @DisplayName("람다 표현식 이용한 쓰레드 ")
    void lambdaExpresstions() {
        Runnable task = () -> {
                int sum = 0 ;
                for ( int i = 0 ; i < 10; i++){
                    sum += i;
                }
                System.out.println(Thread.currentThread()  + " :: " + sum);
         };

        Thread thread01 = new Thread(task);
        Thread thread02= new Thread(task);
        thread01.start();
        thread02.start();
    }
}