package com.android_note.design_pattern.factory_pattern.method_factory;

public class CpuFactory implements ComputerFactory{

    @Override
    public Computer getProduct() {
        return new Cpu();
    }
}
