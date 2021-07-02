package com.android_note.design_pattern.factory_pattern.simple_factory;

import android.util.Log;

public class BenChiCar implements Car {

    @Override
    public void createCar() {
        Log.i("Factory","造一辆奔驰");
    }
}
