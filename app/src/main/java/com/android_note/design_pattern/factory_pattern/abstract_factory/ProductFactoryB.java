package com.android_note.design_pattern.factory_pattern.abstract_factory;

public class ProductFactoryB implements IFactory{

    @Override
    public Computer getComputer() {
        return new ServerComputer();
    }

    @Override
    public Mouse getMouse() {
        return new OfficeMouse();
    }
}
