package com.android_note.client.constraint_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android_note.client.R;

/**
 * 1.Guideline：辅助线 ->Guideline相当于一条虚拟辅助线，可分为水平、垂直线，帮助定位的。
 * 2.基准线：将一个视图的文本基线与另一视图的文本基线对齐。
 * 3.尺寸大小 ：约束布局下的三种大小设置模式 不使用MATCH_PARENT，保留WRAP_CONTENT -》大小设置模式：spread，wrap，percent
 */

public class CommonAuxiliaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_auxiliary);
    }
}
