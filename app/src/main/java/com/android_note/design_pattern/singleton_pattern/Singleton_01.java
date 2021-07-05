package com.android_note.design_pattern.singleton_pattern;

/**
 * 懒汉模式（线程不安全）
 *      单例模式有一个特点就是不允许外部直接创建，也就是new Singleton_01()，因此这里在默认的构造函数上添加了私有属性 private。
 *      目前此种方式的单例确实满足了懒加载,但是如果有多个访问者同时去获取对象实例,就会造成多个同样的实例并存
 */

public class Singleton_01 {

    private static Singleton_01 instance;

    private Singleton_01() { }

    public static Singleton_01 getInstance(){
        if (instance!=null) return instance;
        return new Singleton_01();
    }

}
