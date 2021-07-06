package com.android_note.design_pattern.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{

    // 温度
    private double temperature;
    // 湿度
    private double humidity;
    // 气压
    private double pressure;
    private List<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setData(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
