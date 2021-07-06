package com.android_note.design_pattern.decorator_pattern;

public class Milk extends CondimentDecorator{

    private Coffee coffee;

    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Mike";
    }

    @Override
    public double cost() {
        return coffee.cost() + 2.0;
    }

}
