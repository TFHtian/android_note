package com.android_note.client.android_thread.bean;

import android.util.Log;

public class Animal {
    public String name;
    public Book book;

    public Animal(String name) {
        this.name = name;
        book = new Book("《Android 开发艺术探索》");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void speak() {
        for (int i = 0; i <= 5; i++) {
            Log.d("AAA", name + "第 " + i + " 次" + "非同步叫唤," + "Thread: " + Thread.currentThread().getName() + " / Time: " + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized public void speakSynchronized() {
        for (int i = 0; i <= 5; i++) {
            Log.d("AAA", name + "第 " + i + " 次" + "同步叫唤," + "Thread: " + Thread.currentThread().getName() + " / Time: " + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized public void otherSynchronized() {
        for (int i = 0; i <= 5; i++) {
            Log.d("AAA", name + "其他同步方法," + " 第 " + i + " 次" + ", Thread: " + Thread.currentThread().getName() + " / Time: " + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
