package com.android_note.design_pattern.adapter_pattern;

public class ClassAdapter extends Iphone implements Android{

    @Override
    public void isAndroid() {
        isIphone();
    }

}
