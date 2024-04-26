package com.android_note.design_pattern.template_pattern;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 模板模式：抽象类中定义抽象方法的执行顺序，并将抽象方法设定为只有子类实现，但不设计独立访问的方法。简单说也就是把你安排的明明白白的。
 *
 * 组成：模板方法模式由两部分结构组成：抽象父类和具体的实现子类。通常在抽象父类中封装了子类的算法框架，也包括实现一些公共方法以及封装子类中所有方法的执行顺序。
 *         子类通过继承这个抽象类，也继承了整个算法结构，并且可以选择重写父类的方法
 *
 */
public class TemplatePatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_pattern);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {
            ScanBicycle scanBicycle = new ScanBicycle();
            scanBicycle.isNeedUnlock(false);
            scanBicycle.use();

            CodeBicycle codeBicycle = new CodeBicycle();
            scanBicycle.isNeedUnlock(true);
            codeBicycle.use();

            BossWork bossWork = new BossWork();
            StaffWork staffWork = new StaffWork();
            bossWork.newDay();
            System.out.println("====================");
            staffWork.newDay();

        });
    }

}
