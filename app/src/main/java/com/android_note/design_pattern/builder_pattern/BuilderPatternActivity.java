package com.android_note.design_pattern.builder_pattern;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 建造者模式:
 *      使用多个简单的对象一步一步构建成一个复杂的对象,一个 Builder 类会一步一步构造最终的对象。该 Builder 类是独立于其他对象的。
 *      使用场景：一些基本物料不会变，而其组合经常变化的时候，就可以选择这样的设计模式来构建代码。
 *
 *      android应用场景：dialog 、popupwindow 、http
 */
public class BuilderPatternActivity extends AppCompatActivity {

    public static final String TAG = "BuilderPatternActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder_pattern);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn1).setOnClickListener(v -> {
            CustomBuilder builder =  new CustomBuilder.Builder()
                    .setTitle("测试标题")
                    .setContent("测试内容")
                    .build();
            builder.doTask();
        });

        findViewById(R.id.btn2).setOnClickListener(v -> {
            //CreateController createController = new CreateController();
            //Log.i(TAG,"----------"+createController.getDetail(1));
            //Log.i(TAG,"----------"+createController.getDetail(2));

            CreateBuilder builder = new CreateBuilder();
            Log.i(TAG,"----------"+builder.levelOne().getDetail());
            Log.i(TAG,"----------"+builder.levelTwo().getDetail());
        });
    }

}
