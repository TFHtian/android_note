package com.android_note.design_pattern.factory_pattern.simple_factory;

public interface CarFactory {

    <T extends Car> T createCar(Class<T> cla);  //通过反射动态创建

    Car createCar(String type);  //通过type类型创建 产品对象类
}
