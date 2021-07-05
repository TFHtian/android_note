package com.android_note.design_pattern.singleton_pattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 静态类使用创建单例
 * 这样静态类的方式可以在第一次运行的时候直接初始化Map类
 */

public class Singleton_00 {

    public static Map<String,String> cache = new ConcurrentHashMap<String, String>();
}
