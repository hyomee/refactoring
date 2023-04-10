package com.hyomee.thread;

import static java.lang.Thread.sleep;

public class Task implements Runnable {
    @Override
    public void run() {
        int sum = 0 ;
        for ( int i = 0 ; i < 10; i++){
            sum += i;
        }
        System.out.println(Thread.currentThread()  + " :: " + sum);
    }
}
