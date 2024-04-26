package com.android_note.design_pattern.facade_pattern;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 外观模式 ：隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的接口
 */
public class FacadePatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facade_pattern);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {
            AiFacade facade = new AiFacade();
            facade.on();
            facade.off();
            ShapeMaker shapeMaker = new ShapeMaker();
            shapeMaker.drawCircle();
        });
    }

}
