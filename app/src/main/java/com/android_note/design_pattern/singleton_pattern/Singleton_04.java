package com.android_note.design_pattern.singleton_pattern;

/**
 *  内部类模式（线程安全）
 *  使用类的静态内部类实现的单例模式，既保证了线程安全有保证了懒加载，同时不会因为加锁的方式耗费性能
 */
public class Singleton_04 {

    private static class SingletonHolder{
        private static Singleton_04 instance = new Singleton_04();
    }

    private Singleton_04() { }

    public static Singleton_04 getInstance(){
        return SingletonHolder.instance;
    }

}
