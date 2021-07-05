package com.android_note.design_pattern.factory_pattern.abstract_factory;

public class ProductFactoryA implements IFactory{

    @Override
    public Computer getComputer() {
        return new PcComputer();
    }

    @Override
    public Mouse getMouse() {
        return new GameMouse();
    }
}
