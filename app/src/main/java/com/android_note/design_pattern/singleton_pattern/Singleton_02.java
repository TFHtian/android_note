package com.android_note.design_pattern.singleton_pattern;

/**
 * 懒汉模式（线程安全）
 * 把锁加到方法上后，所有的访问都因需要锁占用导致资源的浪费
 */
public class Singleton_02 {

    private static Singleton_02 instance;

    private Singleton_02() { }

    public static synchronized Singleton_02 getInstance(){
        if (instance!=null) return instance;
        return new Singleton_02();
    }

}
