package com.android_note.client.android_thread;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;
import com.android_note.client.android_thread.bean.Animal;

public class ThreadSynchronizedActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_synchronized);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_test).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test:
                test1();
                break;
        }
    }

    /**
     * test1: 2个线程同时调用 animal 的同步方法
     */
    private void test1(){
        Animal dog = new Animal("灰灰");
        Thread t1 = new Thread() {
            @Override
            public void run() {
                super.run();
                Log.d("AAA", Thread.currentThread().getName() + "开始执行......" + " / Time: " + System.currentTimeMillis());
                dog.speakSynchronized();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                super.run();
                Log.d("AAA", Thread.currentThread().getName() + "开始执行......" + " / Time: " + System.currentTimeMillis());
                dog.speakSynchronized();
            }
        };

        t1.start();
        t2.start();
    }

}
