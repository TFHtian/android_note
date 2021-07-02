package com.android_note.design_pattern.factory_pattern.simple_factory;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.android_note.client.R;

/**
 *  普通工厂模式
 *  包含：1.一个抽象产品类    2.具体产品类    3.一个工厂
 *
 *  把类的实例化交给工厂,易于解耦。但添加具体产品需要修改工厂
 */
public class SimpleFactoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_factory);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {
            CreateCarFactory factory = new CreateCarFactory();
            Car bCar = factory.createCar("B");
            bCar.createCar();
            Car fCar = factory.createCar(FerrariCar.class);
            fCar.createCar();
        });
    }

}
