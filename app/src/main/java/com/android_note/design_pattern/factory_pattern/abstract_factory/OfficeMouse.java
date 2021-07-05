package com.android_note.design_pattern.factory_pattern.abstract_factory;

import android.util.Log;

public class OfficeMouse extends Mouse{

    @Override
    public void createMouse() {
        Log.i("Factory","create OfficeMouse");
    }
}
