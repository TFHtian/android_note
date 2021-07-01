package com.android_note.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class CustomService extends Service {

    private CustomBinder binder;

    @Override
    public void onCreate() {
        super.onCreate();
        binder = new CustomBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        if (binder!=null){
            return binder;
        }else {
            return null;
        }
    }

    class CustomBinder extends Binder{

        public String getData(){
            return "bindCustomService";
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
