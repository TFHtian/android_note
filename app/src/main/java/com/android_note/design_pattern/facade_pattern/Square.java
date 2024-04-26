package com.android_note.design_pattern.facade_pattern;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
