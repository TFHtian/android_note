package com.android_note.client.custom_view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;
import com.android_note.client.custom_view.custom.PPCircleProgressView;

/**
 * 自定义view分类：
 *  一、组合控件：项目中公用的相同组件封装，构成一个新的控件-》根据给定布局实现自定义View -》LayoutInflater.from(context).inflate(R.layout.xx, this) 引入布局，做渲染逻辑处理
 *  二、继承控件：希望在原有系统控件基础上做一些修饰性的修改，而不会做大幅度的改动。如在TextView的文字下方添加下划线，继承特定父view，在原有基础上修改
 *  三、自绘控件：基础View ,绘制，布局处理（复杂view）
 */

public class CustomCircleActivity extends AppCompatActivity {

    PPCircleProgressView progressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_circle);
        progressView = findViewById(R.id.progress_view);
        progressView.showAnimation(0,100,3000);
    }

}
