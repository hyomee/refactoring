package com.hyomee.thread.synchronize;

public class SleedUtils {
     static void sleep(long millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }
    }
}
