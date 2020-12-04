package com.android_note.client.animation.transition_animation;

import java.io.Serializable;

public class CustomTransitionBean implements Serializable {

    private String name;
    private int imResId;

    public CustomTransitionBean(String name, int imResId) {
        this.name = name;
        this.imResId = imResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImResId() {
        return imResId;
    }

    public void setImResId(int imResId) {
        this.imResId = imResId;
    }
}
