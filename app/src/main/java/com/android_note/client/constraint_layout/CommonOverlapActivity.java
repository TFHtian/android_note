package com.android_note.client.constraint_layout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * @author TFHtian
 * @date 2021/5/18.
 * @description
 * 特殊布局：重叠 可用辅助线和view或者space
 * 某个布局的一半覆盖
 */
public class CommonOverlapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_overlap);
    }
}
