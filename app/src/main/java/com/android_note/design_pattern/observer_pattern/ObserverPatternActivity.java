package com.android_note.design_pattern.observer_pattern;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android_note.client.R;

/**
 * 观察者模式
 *      ：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新
 *
 *  结构组成：
 *      Subject（抽象主题角色）：把所有对观察者对象的引用保存在一个集合中，每个抽象主题角色都可以由任意数量的观察者。抽象主题提供一个接口，可以增加和删除观察者角色。一般用一个抽象类和接口来实现。
 *      Concretesubject（具体主题角色）：在具体主题内部状态改变时，给所有登记过的观察者发出通知。
 *      Observer（抽象观察者角色）：为所有具体的观察者定义一个接口，在得到主题的通知时更新自己。
 *      ConcreteObserver（具体观察者角色）：该角色实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题的状态相协调。如果需要，具体观察者角色可以保存一个指向具体主题角色的引用。
 *
 *
 */
public class ObserverPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer_pattern);
        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(v -> {

            WeatherData weatherData = new WeatherData();
            CurrentConditions currentConditions = new CurrentConditions(weatherData);
            BaiDuSite baiduSite = new BaiDuSite(weatherData);

            weatherData.registerObserver(currentConditions);
            weatherData.registerObserver(baiduSite);

            weatherData.setData(25, 75, 40);

            System.out.println("---------------------------------------------");
            weatherData.removeObserver(currentConditions);
            weatherData.setData(30, 80, 45);
        });
    }

}
