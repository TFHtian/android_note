package com.android_note.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * service服务
 *
 * 相关问题 ：1.如何与activity 通信 2.为何不能耗时操作 3.如何保活 4.与线程的区别
 *
 * 一、service不是一个线程，是运行在宿主进程中的主线程中，所以不能做耗时操作，否则导致ANR异常
 *
 * 二、service 本职：
 *      1.告诉当前系统，当前程序需要在后台做一些处理，意味着service不需要跟用户有交互，不需UI 交互，即无论开启它的页面是否销毁，只要进程不销毁它一直运行在后台
 *      可以通过startService方式启动 （改方式除非调用stopService或者内部调用stopSelf否则一直运行）
 *      startService()只要一个Intent参数 ：Intent intent = new Intent(XXActivity.this, XXService.class);
 *      首次启动 调用onCreate 再调用 onStartCommand 如果已启动则直接调用onStartCommand
 *      当调用stopSelf()或者stopService()后，会执行onDestroy(),代表Service生命周期结束
 *      startService可以多次调用，每次调用都会执行onStartCommand()。
 *      不管调用多少次startService，只需要调用一次stopService就结束。
 *      如果startService后没有调用stopSelf或者stopService，则Service一直存活并运行在后台。
 *
 *     2.程序通过service对外开放某些操作，通过bindService与service调用，长连接交互，Service生命周期和其绑定的组件相关
 *     bindService方式：由于bindService是异步执行的，所以需要额外构建一个ServiceConnection对象用与接收bindService的状态，同时还要指定bindService的类型。
 *     （1）. 定义用于通信的对象Binder，在Service的onBind()中返回的对象。
 *      (2) . 定义用于接收状体的ServiceConnection
 *      (3) .在需要的地方绑定到Service
 *     通过bindService方式与Service进行绑定后，当没有对象与Service绑定后，Service生命周期结束，这个过程包括绑定对象被销毁，或者主动掉调用unbindService()
 *
 * 三、与thread的区别
 *      1.Thread 的运行是独立的，也就是说当一个 Activity 被 finish 之后，如果没有主动停止 Thread 或者 Thread 里的 run 方法没有执行完毕的话，Thread 也会一直执行
 *      当 Activity 被 finish 之后，不再持有该 Thread 的引用，也就是不能再控制该Thread。另一方面，没有办法在不同的 Activity 中对同一 Thread 进行控制
 *
 *      2.可以把 Service 想象成一种消息服务，可以在任何有 Context 的地方调用 Context.startService、Context.stopService、Context.bindService、Context.unbindService来控制它，
 *      也可以在 Service 里注册 BroadcastReceiver，通过发送 broadcast 来达到控制的目的，这些都是 Thread 做不到的。
 *
 * 四、保活：
 *      1.提高Service的优先级，在在AndroidManifest.xml文件中对于intent-filter可以通过android:priority = "1000"这个属性设置最高优先级，1000是最高值，如果数字越小则优先级越低
 *      2.通过startForeground将service放到前台状态，就会减少被杀死的概率
 *      3.在onDestroy方法里重启Service
 *
 */
public class CustomServiceActivity extends AppCompatActivity {

    private ServiceConnection connection;
    private CustomService.CustomBinder mBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_service);
        initConnection();
        initView();
    }

    private void initView() {
        findViewById(R.id.btn1).setOnClickListener(v -> {
            Intent intent = new Intent(CustomServiceActivity.this,SimpleService.class);
            startService(intent);
        });
        findViewById(R.id.btn2).setOnClickListener(v -> {
            Intent bindIntent = new Intent(CustomServiceActivity.this, CustomService.class);
            bindService(bindIntent, connection, BIND_AUTO_CREATE);
        });
    }

    private void initConnection(){
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mBinder = (CustomService.CustomBinder) service;
                Toast.makeText(CustomServiceActivity.this, mBinder.getData(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

}
