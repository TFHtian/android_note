package com.android_note.design_pattern.facade_pattern;

public class AiFacade {

    private Light light;
    private AirCondition airCondition;

    public AiFacade() {
        light = new Light();
        airCondition = new AirCondition();
    }

    public void on(){
        light.on();
        airCondition.on();
    }

    public void off(){
        light.off();
        airCondition.off();
    }
}
