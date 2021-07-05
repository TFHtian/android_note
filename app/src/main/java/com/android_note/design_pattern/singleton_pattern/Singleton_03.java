package com.android_note.design_pattern.singleton_pattern;

/**
 * 饿汉模式
 *  与静态类基本一致 在程序启动的时候直接运行加载，不能懒加载
 *  导致问题为：模块化还没打开，但已经初始化成功，导致手机卡
 */

public class Singleton_03 {

    private static final Singleton_03 instance = new Singleton_03();

    private Singleton_03() { }

    public static Singleton_03 getInstance(){
        return instance;
    }
}
