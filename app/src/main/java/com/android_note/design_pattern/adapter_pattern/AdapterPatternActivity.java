package com.android_note.design_pattern.adapter_pattern;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 适配器模式 :将一个类的接口转换成客户希望的另一个接口。
 * Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作
 * 实现：适配器继承或依赖已有的对象，实现想要的目标接口
 *
 * 分类：（1.类适配器  2.对象适配器  3.缺省适配器）
 *
 */
public class AdapterPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_pattern);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {
            //类适配器
            //Android android = new ClassAdapter();
            //android.isAndroid();
            //对象适配器
            //Android android = new ObjectAdapter(new Iphone());
            //android.isAndroid();
            //缺省适配器
            SubjectAdapter adapter = new SubjectAdapter() {
                @Override
                public void learnEnglish() {
                    Log.i("pattern","爱学英语");
                }
            };
            adapter.learnEnglish();
        });
    }

}
