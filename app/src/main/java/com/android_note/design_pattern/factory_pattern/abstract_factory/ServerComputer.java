package com.android_note.design_pattern.factory_pattern.abstract_factory;

import android.util.Log;

public class ServerComputer extends Computer{

    @Override
    public void createComputer() {
        Log.i("Factory","create ServerComputer");
    }
}
