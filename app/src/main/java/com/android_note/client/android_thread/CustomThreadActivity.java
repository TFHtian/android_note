package com.android_note.client.android_thread;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;

/**
 * 开启线程方式
 */

public class CustomThreadActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_thread);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_start).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start:
                createThread6();
                break;
        }
    }

    /**
     * 方式一：集成thread，重写run
     */
    private void createThread1(){
        MyThread myThread = new MyThread();
        myThread.start();
    }

    public static class MyThread extends Thread{

        @Override
        public void run() {
            super.run();
            System.out.println("处理");
        }
    }

    /**
     * 方式二：实现runnable接口
     */

    private void createThread2(){
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("处理");
        }
    }

    /**
     * 方式三：使用函数体
     */
    private void createThread3(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("处理");
            }
        }).start();
    }

    /**
     * 方式四：线程工厂类 ThreadFactory
     */
    private void createThread4(){
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义线程");
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("处理");
            }
        };

        Thread thread = factory.newThread(runnable);
        thread.start();
    }

    /**
     * 方式五：实现callable接口
     */
    private void createThread5(){
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("处理");
                return "处理完成";
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();
    }

    /**
     * 方式六：线程池
     */
    private void createThread6(){
        Executors.newCachedThreadPool().submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("处理");
            }
        });
    }

}
