package com.android_note.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 组件广播应用
 *
 *  广播分为两个角色：广播发送者、广播接收者
 *  作用：监听 / 接收 应用 App 发出的广播消息，并 做出响应
 *  场景：
 *      1.Android不同组件间的通信
 *      2.与 Android 系统在特定情况下的通信（电话、网络）
 *
 *  注册方式：
 *      1.静态注册：在AndroidManifest.xml里通过<receive>标签声明 。当此 App首次启动时，系统会自动实例化BroadcastReceiver类，并注册到系统中
 *      2.动态注册：在代码中调用Context.registerReceiver（）方法
 *         *动态广播最好在Activity 的 onResume()注册、onPause()注销。对于动态广播，有注册就必然得有注销，否则会导致内存泄露
 *         在onResume()注册、onPause()注销是因为onPause()在App死亡前一定会被执行，从而保证广播在App死亡前一定会被注销，从而防止内存泄露。
 *         不在onCreate() & onDestory() 或 onStart() & onStop()注册、注销是因为：
 *         当系统因为内存不足（优先级更高的应用需要内存）要回收Activity占用的资源时，Activity在执行完onPause()方法后就会被销毁，有些生命周期方法onStop()，onDestory()就不会执行。当再回到此Activity时，是从onCreate方法开始执行。
 *
 *  两种方式的区别：
 *      1.静态注册：常驻，不收任何组件影响
 *      2.动态注册：灵活，跟随组件生命周期
 *
 */
public class CommonBroadcastActivity extends AppCompatActivity {

    public static final String TAG = "BroadcastActivity";
    public static String ACTION_INTENT_RECEIVER = "RECEIVER";
    private SimpleReceiver simpleReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_broadcast);
        initView();
    }

    private void initView(){
        findViewById(R.id.btn_post).setOnClickListener(v -> {
            //发送广播
            Intent i = new Intent(SimpleReceiver.ACTION);
            i.putExtra("type", "test");
            i.putExtra("age", 18);
            sendBroadcast(i);
        });
    }

    public void registerMessageReceiver() {
        messageReceiver = new MessageReceiver();
        registerReceiver(messageReceiver, new IntentFilter(ACTION_INTENT_RECEIVER));
    }

    //接收广播
    public MessageReceiver messageReceiver;

    class MessageReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "----" + intent.getIntExtra("age", 0));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //注册
        simpleReceiver = new SimpleReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SimpleReceiver.ACTION);
        registerReceiver(simpleReceiver, intentFilter);
        registerMessageReceiver();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //销毁在onResume()方法中的广播
        if (simpleReceiver!=null){
            unregisterReceiver(simpleReceiver);
        }
        if (messageReceiver!=null){
            unregisterReceiver(messageReceiver);
        }
    }

}
