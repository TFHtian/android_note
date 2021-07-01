package com.android_note.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SimpleReceiver extends BroadcastReceiver {

    public static final String TAG = "SimpleReceiver";
    public static final String ACTION = "SIMPLE_ACTION";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getStringExtra("type") != null)
            if (intent.getStringExtra("type").equals("test")) {
                Log.i(TAG, "----" + intent.getIntExtra("age", 0));
                //向Activity中的BroadcastReceiver对象发送消息
                Intent i = new Intent(CommonBroadcastActivity.ACTION_INTENT_RECEIVER);
                i.putExtra("name", "hello");
                i.putExtra("age", 20);
                context.sendBroadcast(i);
            }
    }

}
