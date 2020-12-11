package com.android_note.client.android_thread.bean;

import android.util.Log;

public class Book {

    public String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void speak() {
        for (int i = 0; i <= 5; i++) {
            Log.d("AAA", name + "第 " + i + " 次" + "非同步阅读," + "Thread: " + Thread.currentThread().getName() + " / Time: " + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized public void speakSynchronized() {
        for (int i = 0; i <= 5; i++) {
            Log.d("AAA", name + "第 " + i + " 次" + "同步阅读," + "Thread: " + Thread.currentThread().getName() + " / Time: " + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
