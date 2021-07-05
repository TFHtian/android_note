package com.android_note.design_pattern.factory_pattern.abstract_factory;

import android.util.Log;

public class GameMouse extends Mouse{

    @Override
    public void createMouse() {
        Log.i("Factory","create GameMouse");
    }
}
