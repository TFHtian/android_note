package com.android_note.design_pattern.factory_pattern.method_factory;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 工厂方法模式 ：称工厂模式也叫多态工厂
 * 工厂父类负责定义创建产品对象的公共接口，而工厂子类则负责生成具体的产品对象，
 * 这样做的目的是将产品类的实例化操作延迟到工厂子类中完成，即通过工厂子类来确定究竟应该实例化哪一个具体产品类。
 *  包含：
 *      1.一个抽象产品类
 * 多个具体产品类
 * 一个抽象工厂
 * 多个具体工厂 - 每一个具体产品对应一个具体工厂
 */
public class FactoryMethodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_method);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {
            ComputerFactory cpu_factory = new CpuFactory();
            cpu_factory.getProduct().create();
            ComputerFactory disk_factory = new DiskFactory();
            disk_factory.getProduct().create();
        });
    }

}
