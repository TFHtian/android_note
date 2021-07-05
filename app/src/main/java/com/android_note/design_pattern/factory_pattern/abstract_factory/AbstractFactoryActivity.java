package com.android_note.design_pattern.factory_pattern.abstract_factory;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 *  抽象工厂模式
 *      提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。
 *      在工厂方法模式中具体工厂负责生产具体的产品，每一个具体工厂对应一种具体产品，工厂方法也具有唯一性，一般情况下，
 *      一个具体工厂中只有一个工厂方法或者一组重载的工厂方法。 但是有时候我们需要一个工厂可以提供多个产品对象，而不是单一的产品对象。
 *  包含：
 *      多个抽象产品类
 *      具体产品类
 *      抽象工厂类 - 声明(一组)返回抽象产品的方法
 *      具体工厂类 - 生成(一组)具体产品
 *
 */
public class AbstractFactoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstract_factory);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {
            IFactory aFactory = new ProductFactoryA();
            aFactory.getComputer().createComputer();
        });
    }

}
