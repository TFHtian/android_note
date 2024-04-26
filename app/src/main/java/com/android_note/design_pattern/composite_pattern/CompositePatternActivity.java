package com.android_note.design_pattern.composite_pattern;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 比如公司的部门，每个部门下面还可以在创建部门，部门下面可以有子部门也可以有员工
 * 实现代码如下：
 */
public class CompositePatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composite_pattern);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {

            Department department1 = new Department("土豆1-1", 1);
            Department department2 = new Department("土豆2-1", 2);
            Department department3 = new Department("土豆2-2", 2);

            Staff staff0 = new Staff("张三0");
            Staff staff1 = new Staff("张三1");
            Staff staff2 = new Staff("张三2");
            Staff staff3 = new Staff("张三3");
            Staff staff4 = new Staff("张三4");
            Staff staff5 = new Staff("张三5");

            department1.addChild(department2);
            department1.addChild(department3);
            department1.addChild(staff0);
            department2.addChild(staff1);
            department2.addChild(staff2);
            department2.addChild(staff3);
            department2.addChild(staff4);
            department3.addChild(staff5);
            department1.print();

        });
    }

}
