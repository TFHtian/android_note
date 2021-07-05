package com.android_note.design_pattern.factory_pattern.method_factory;

import android.util.Log;

public class Cpu implements Computer{

    @Override
    public void create() {
        Log.i("Factory","create cpu");
    }
}
