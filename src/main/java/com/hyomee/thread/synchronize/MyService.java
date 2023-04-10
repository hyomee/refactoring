package com.hyomee.thread.synchronize;

public class MyService {
    private volatile String str = "";

     void testSync01(String value) {
        this.str = value;
         System.out.println(String.format("[testSync01 START] 현재 쓰레드 ID : %s, NAME : %s, 값 = %s",
                 Thread.currentThread().getId(),
                 Thread.currentThread().getName(),
                 this.str));

         SleedUtils.sleep(2000);

        System.out.println(String.format("[testSync01 END  ] 현재 쓰레드 ID : %s, NAME : %s, 값 = %s ",
                Thread.currentThread().getId(),
                Thread.currentThread().getName(),
                this.str));
    }
}
