package com.hyomee.newObject.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    void getInstance() {
    }

    @Test
    @DisplayName("기본 싱글톤")
    void singleton_test() {
        Singleton singleton01 = Singleton.getInstance("Init_01");
        Singleton singleton02 = Singleton.getInstance("Init_02");
        System.out.println("singleton01 :: " + singleton01.getValue());
        System.out.println("singleton02 :: " + singleton02.getValue());
    }

    @Test
    @DisplayName("기본 싱글톤")
    void singleton_multiThread_test() {
        Runnable singleton_thread_01 = ()-> {
            Singleton singleton01 = Singleton.getInstance("Init_01");
            System.out.println("singleton01 :: " + singleton01.getValue());
        };

        Runnable singleton_thread_02 = ()-> {
            Singleton singleton02 = Singleton.getInstance("Init_02");
            System.out.println("singleton02 :: " + singleton02.getValue());
        };

        Thread thread01 = new Thread(singleton_thread_01);
        Thread thread02 = new Thread(singleton_thread_02);
        thread01.start();
        thread02.start();

//        singleton_thread_01.run();
//        singleton_thread_02.run();
    }

}