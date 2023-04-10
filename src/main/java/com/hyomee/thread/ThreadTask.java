package com.hyomee.thread;

public class ThreadTask extends Thread {

    public  void run() {
        System.out.println(String.format("현제 쓰레드 ID : %s, NAME : %s",
                Thread.currentThread().getId(),
                Thread.currentThread().getName()));
    }
}
