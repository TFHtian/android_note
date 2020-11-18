package com.android_note.client.constraint_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android_note.client.R;

/***
 * low 是 VirtualLayout，Flow 可以像 Chain 那样帮助快速横向/纵向布局
 */
public class CommonFlowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_flow);
    }
}
