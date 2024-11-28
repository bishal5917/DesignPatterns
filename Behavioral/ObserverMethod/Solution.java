package Behavioral.ObserverMethod;

import java.util.ArrayList;
import java.util.List;

// The observer design pattern is a behavioral design pattern that defines
// a one to many dependency between objects. When one object(subject) changes it's state,
// all of its dependents(observers) are notified and updated automatically.

// Let's consider a case where a weather station is the central point of providing information
// regarding weather changes. It maintains a list of registered devices like TV, Radio or SmartPhones.
// When a weather changes, the changes are sent to all of the registered devices.

// Observer interface
interface Observer {
    void update(String weather);
}

// Subject interface
interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

// Concrete subject
class WeatherStation implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String weather;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(weather);
        }
    }

    public void setWeather(String weather) {
        this.weather = weather;
        notifyObservers();
    }

}

// Concrete observer class
class Phone implements Observer {

    private String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        System.out.println("Weather updated on Phone: " + this.weather);
    }

}

// Concrete observer class
class TV implements Observer {

    private String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        System.out.println("Weather updated on TV: " + this.weather);
    }

}

public class Solution {

    // Accessing from the client side
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer tv = new TV();
        Observer phone = new Phone();

        weatherStation.addObserver(tv);
        weatherStation.addObserver(phone);

        // Simulating a weather change
        weatherStation.setWeather("HEAVY RAIN");
    }
}
