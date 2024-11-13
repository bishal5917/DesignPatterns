package Creational.AbstractFactoryMethod;

//abstract factory interface
interface CarFactory {
    Car createCar();

    CarSpecification createSpecification();
}

// concrete factory
class NorthAmericanCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Tesla();
    }

    @Override
    public CarSpecification createSpecification() {
        return new NorthAmericanCarSpecification();
    }
}

// concrete factory
class EuropeanCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new Ferrari();
    }

    @Override
    public CarSpecification createSpecification() {
        return new EuropeanCarSpecification();
    }
}

// Abstract Product Interface for Cars
interface Car {
    void assemble();
}

// Abstract Product Interface for Car Specifications
interface CarSpecification {
    void display();
}

// concrete product interface
class Ferrari implements Car {

    @Override
    public void assemble() {
        System.out.println("Toyota Car Assembled");
    }
}

// concrete product interface
class Tesla implements Car {

    @Override
    public void assemble() {
        System.out.println("Tesla Car Assembled");
    }
}

// concrete car specs class
class NorthAmericanCarSpecification implements CarSpecification {
    @Override
    public void display() {
        System.out.println("North American car specs");
    }
}

// concrete car specs class
class EuropeanCarSpecification implements CarSpecification {
    @Override
    public void display() {
        System.out.println("European car specs");
    }
}

public class Solution {
    public static void main(String[] args) {
        // Creating cars for North America
        CarFactory northAmericaCarFactory = new NorthAmericanCarFactory();
        Car northAmericanCar = northAmericaCarFactory.createCar();
        CarSpecification northAmericaSpecs = northAmericaCarFactory.createSpecification();
        northAmericanCar.assemble();
        northAmericaSpecs.display();
    }
}
