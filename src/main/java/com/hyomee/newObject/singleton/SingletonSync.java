package com.hyomee.newObject.singleton;

public class SingletonSync {
    private static volatile SingletonSync instance;
    private String value;

    private SingletonSync(String value) {
        System.out.println(value + " 값으로 Singleton 객체가 셍성 되었습니다");
        this.value = value;
    }

    public static SingletonSync getInstance(String value) {
        SingletonSync singletonSync = instance;
        if (singletonSync != null) {
            return singletonSync;
        }
        synchronized(SingletonSync.class) {
            if (instance == null) {
                instance = new SingletonSync(value);
            }
        }
        return instance;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
