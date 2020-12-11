package com.android_note.client.android_thread;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 线程间的通信方式
 */
public class ThreadCommunicationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_communication);
        initView();
    }

    private void initView() {
        tvContent = findViewById(R.id.tv_content);
        findViewById(R.id.btn_tst).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tst:
                communication4();
                break;
        }
    }

    /**
     * 方式一：View.post
     */
    private void communication1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tvContent.post(new Runnable() {
                    @Override
                    public void run() {
                        tvContent.setText("使用View.post通信刷新");
                    }
                });
            }
        }).start();
    }

    /**
     * 方式二：Activity.runOnUiThread
     */
    private void communication2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvContent.setText("使用runOnUiThread()通信刷新");
                    }
                });
            }
        }).start();
    }

    private Handler handler = new Handler();

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    String text = (String) msg.obj;
                    tvContent.setText(text);
                    break;
            }
        }
    };

    /**
     * 方式三：handler通信
     */
    private void communication3(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        tvContent.setText("使用handler通信刷新");
//                    }
//                });
                Message msg = new Message();
                msg.what = 1;
                msg.obj = "handler通信";
                mHandler.sendMessage(msg);
            }
        }).start();
    }

    /**
     * 方式四：AsyncTask
     */
    private void communication4(){
        new MyAsyncTask().execute("通过AsyncTask方法");
    }

    private class MyAsyncTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return objects[0].toString();
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            tvContent.setText(o.toString());
        }
    }


    /**
     * 方式五：使用 EventBus
     */

}
