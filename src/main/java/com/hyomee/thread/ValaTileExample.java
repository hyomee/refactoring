package com.hyomee.thread;

public class ValaTileExample extends Thread {
    private String volatileNamw  ;
    String name;
    ValaTileMain t;
    public ValaTileExample(String str, ValaTileMain t) {
        this.name = str;
        this.t = t;
    }
    public void run() {
        for (int i = 0; i < 10000; i++) {
            ValaTileMain.i.getAndAdd(1);
            // t.i = t.i + 1;
        }

        System.out.println(name + " :: " + ValaTileMain.i.get() + "::::: END");

        // System.out.println(name + " :: " + t.i  + "::::: END");
    }

}
