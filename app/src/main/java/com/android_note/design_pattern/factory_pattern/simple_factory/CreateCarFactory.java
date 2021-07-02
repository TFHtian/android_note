package com.android_note.design_pattern.factory_pattern.simple_factory;

public class CreateCarFactory implements CarFactory {

    @Override
    public <T extends Car> T createCar(Class<T> cla) {
        Car car = null;
        try {
            car = (Car) Class.forName(cla.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) car;
    }

    @Override
    public Car createCar(String type) {
        switch (type){
            case "B":
                return new BenChiCar();
            case "F":
                return new FerrariCar();
        }
        return null;
    }
}
