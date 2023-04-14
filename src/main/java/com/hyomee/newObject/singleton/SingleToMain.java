package com.hyomee.newObject.singleton;

public class SingleToMain {

    public static void main(String... str) {
        // singleThreadSingleTon();
        // multiThreadSingleTon();
        multiThreadSingletonSync();
        // multiThreadSingleTon_01();
    }

    public static void singleThreadSingleTon() {
        Singleton singleton01 = Singleton.getInstance("Init_01");
        Singleton singleton02 = Singleton.getInstance("Init_02");
        System.out.println("singleton01 :: " + singleton01.getValue());
        System.out.println("singleton02 :: " + singleton02.getValue());
    }

    public static void multiThreadSingleTon() {
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
    }

    public static void multiThreadSingletonSync() {
        Runnable singleton_thread_01 = ()-> {
            SingletonSync singleton01 = SingletonSync.getInstance("Init_01");
            System.out.println("singleton01 :: " + singleton01.getValue());
        };

        Runnable singleton_thread_02 = ()-> {
            SingletonSync singleton02 = SingletonSync.getInstance("Init_02");
            System.out.println("singleton02 :: " + singleton02.getValue());
        };

        Thread thread01 = new Thread(singleton_thread_01);
        Thread thread02 = new Thread(singleton_thread_02);
        thread01.start();
        thread02.start();
    }

    public static void multiThreadSingleTon_01() {

        SingletonSync singleton01 = SingletonSync.getInstance("Init_01");
        SingletonSync singleton02 = SingletonSync.getInstance("Init_02");

        Runnable singleton_thread_01 = ()-> {
            System.out.println("singleton_thread_01 START:: " + singleton01.getValue());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("singleton_thread_01 원하는 값 (Init_01) ING   :: " + singleton01.getValue());
            singleton01.setValue("Init_01_01");
            System.out.println("singleton_thread_01 END  :: " + singleton01.getValue());
        };

        Runnable singleton_thread_02 = ()-> {
            System.out.println("singleton_thread_02 START:: " + singleton02.getValue());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            singleton02.setValue("Init_01_02");
            System.out.println("singleton_thread_02 END  :: " + singleton02.getValue());
        };

        Thread thread01 = new Thread(singleton_thread_01);
        Thread thread02 = new Thread(singleton_thread_02);
        thread01.start();
        thread02.start();
        //singleton_thread_01.run();
        //singleton_thread_02.run();
    }
}
