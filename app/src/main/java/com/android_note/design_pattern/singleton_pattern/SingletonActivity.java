package com.android_note.design_pattern.singleton_pattern;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 单例模式：
 *      保证一个类只有一个实例哪怕多线程同时访问，并需要提供一个全局访问此实例的点。
 *      单例模式主要解决的是，一个全局使用的类频繁的创建和消费，从而提升提升整体的代码的性能。 解决一个全局使用的类频繁地创建与销毁。
 *
 * 包含内容：
 *      1、单例类只能有一个实例。
 *      2、单例类必须自己创建自己的唯一实例。
 *      3、单例类必须给所有其他对象提供这一实例。
 *
 *  实现方式：
 *      1.静态类使用
 *      2.懒汉模式（线程安全和线程不安全两种）
 *      3.饿汉模式
 *      4.使用类的内部类模式
 *      5.双重锁校验模式
 *
 */
public class SingletonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {

        });
    }

}
