package com.android_note.client.android_thread;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomLockActivity extends AppCompatActivity implements View.OnClickListener {

    // 锁句柄
    private final String hello = "hello";

    //显示锁
    private final Lock lock = new ReentrantLock();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_lock);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_test).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test:
                try {
                    getLock1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getLock2();
                break;
        }
    }

    private void getLock1() throws InterruptedException {
        synchronized (hello) {
            System.out.println("ThreadA 拿到了内部锁");
            Thread.sleep(2 * 1000);
        }
        System.out.println("ThreadA 释放了内部锁");
    }

    private void getLock2() {
        System.out.println("ThreadB 尝试获取内部锁");
        synchronized (hello) {
            System.out.println("ThreadB 拿到了内部锁");
        }

    }


    /**
     * 显示锁
     */
    private void lock1() {
        lock.lock();
        System.out.println("线程 1 获取了显式锁");
        try {
            System.out.println("线程 1 开始执行操作");
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("线程 1 释放了显式锁");
        }
    }

    private void lock2() {
        lock.lock();
        System.out.println("线程 2 获取了显式锁");
        try {
            System.out.println("线程 2 开始执行操作");
        } finally {
            System.out.println("线程 2 释放了显式锁");
            lock.unlock();
        }
    }

}
