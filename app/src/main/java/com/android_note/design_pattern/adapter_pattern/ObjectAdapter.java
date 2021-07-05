package com.android_note.design_pattern.adapter_pattern;

public class ObjectAdapter implements Android{

    private Iphone iphone;

    public ObjectAdapter(Iphone iphone) {
        this.iphone = iphone;
    }

    @Override
    public void isAndroid() {
        iphone.isIphone();
    }

}
