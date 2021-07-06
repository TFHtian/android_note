package com.android_note.design_pattern.decorator_pattern;


public abstract class Coffee {

    public String description;

    public String getDescription() {
        return description;
    }

    public void serDescription(String description) {
        this.description = description;
    }

    public abstract double cost();

}
