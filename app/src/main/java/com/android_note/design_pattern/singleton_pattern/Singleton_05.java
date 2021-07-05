package com.android_note.design_pattern.singleton_pattern;

/**
 * 双重锁检验模式：
 * 双重锁的方式是方法级锁的优化，减少了部分获取实例的耗时。
 * 同时这种方式也满足了懒加载。
 */

public class Singleton_05 {

    private static Singleton_05 instance;

    private Singleton_05() { }

    public static Singleton_05 getInstance(){
        if (instance!=null) return instance;
        synchronized (Singleton_05.class){
            if (instance==null){
                instance = new Singleton_05();
            }
        }
        return instance;
    }

}
