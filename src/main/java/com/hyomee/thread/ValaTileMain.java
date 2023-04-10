package com.hyomee.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ValaTileMain {

    static AtomicInteger i = new AtomicInteger(0);
    // volatile int i = 0;

    // int i = 0;

    public static void main(String args[]) throws InterruptedException {
        ValaTileMain t = new ValaTileMain();
        ValaTileExample t1 = new ValaTileExample("A", t);
        ValaTileExample t2 = new ValaTileExample("B", t);
        ValaTileExample t3 = new ValaTileExample("C", t);
        ValaTileExample t4 = new ValaTileExample("D", t);
        ValaTileExample t5 = new ValaTileExample("E", t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        Thread.sleep(2000);
        System.out.println(t.i);
    }
}
