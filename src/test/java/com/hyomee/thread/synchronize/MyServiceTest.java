package com.hyomee.thread.synchronize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {


    public static void main(String[] str) {
        test01();
    }
   //  @Test
   static void test01() {
         MyService myService = new MyService();

        Thread thread01 = new Thread() {
            public  void run() {
                System.out.println("thread01 Call testSync01");
                myService.testSync01("TEST SYNC 01");
            }
        };

        Thread thread02 = new Thread() {
            public void run() {
                System.out.println("thread02 Call testSync02");
                myService.testSync01("TEST SYNC 02");
            }
        };

       thread01.setName("1번");
       thread02.setName("2번");
       thread01.start();
       thread02.start();
    }


}