package com.android_note.design_pattern.decorator_pattern;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 装饰器模式 ： 允许向一个现有的对象添加新的功能，同时又不改变其结构
 * 解决：我们为了扩展一个类经常使用继承方式实现，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀。
 *
 */
public class DecoratorPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator_pattern);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {
            Coffee mocha = new Mocha();
            mocha = new Milk(mocha);
            System.out.println(mocha.getDescription() + "$" + mocha.cost());

            Shape circle = new Circle();
            ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
            ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        });
    }

}
