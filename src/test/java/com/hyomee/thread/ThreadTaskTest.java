package com.hyomee.thread;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadTaskTest {

    @Test
    @DisplayName("Thread 확장 멀티 쓰레드")
    void run() {

        for ( int i = 0; i < 2; i++) {
            Thread thread = new ThreadTask();
            thread.start();
        }

    }

    @Test
    @DisplayName("Thread 확장 익명 멀티 쓰레드")
    void anonymousThread() {
        for ( int i = 0; i < 2; i++) {
            Thread thread = new Thread() {
                public  void run() {
                    System.out.println(String.format("현제 쓰레드 ID : %s, NAME : %s",
                            Thread.currentThread().getId(),
                            Thread.currentThread().getName()));
                }
            };
            thread.start();
        }
    }


}