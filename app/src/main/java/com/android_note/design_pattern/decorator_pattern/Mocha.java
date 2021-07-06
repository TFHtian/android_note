package com.android_note.design_pattern.decorator_pattern;

public class Mocha extends Coffee{

    public Mocha() {
        description = "Mocha";
    }

    @Override
    public double cost() {
        return 15.8;
    }
}
