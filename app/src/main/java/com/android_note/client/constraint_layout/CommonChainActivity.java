package com.android_note.client.constraint_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android_note.client.R;

/**
 * 链（chain）布局 ： 快速实现等分布局等
 *
 * 三种约束方式：
 * spread：view之间均匀分布
 * spread_inside：除了约束链的头部和尾部贴在两边，其余均匀分布
 * packed：所有view紧贴在一起，默认居中
 *
 * --两边相对父控件  中间组件相互相对--
 */

public class CommonChainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_chain);
    }
}
