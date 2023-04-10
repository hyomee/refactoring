package com.hyomee.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTypeExample {
    public static void main(String[] args) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread1 : " + atomicInteger.getAndIncrement());
                }
            });
            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread2 : " + atomicInteger.getAndIncrement());
                }
            });
            thread1.start();
            thread2.start();
        }
}