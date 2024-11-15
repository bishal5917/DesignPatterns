package Structural.DecoratorMethod;

// it allows some features and add-ons to the object, 
// without affecting or modifying the behaviour of other objects 
// from the same class

// Here, we are trying to implement a coffee shop process.
// Some coffee are normal, while some might have extra contents like milk,cream,etc as add-ons
// This can be achieved using a decorator pattern.

//abstract coffee class
interface Coffee {
    public String getDescription();

    public double getCost();
}

// concrete classes
class PlainCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Normal Coffee";
    }

    @Override
    public double getCost() {
        return 50.0;
    }

}

// Abstract decorator class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Now lets add a concrete decorator
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + " with milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 100.0;
    }
}

public class Solution {
    public static void main(String[] args) {
        // Plain coffee
        Coffee plainCoffee = new PlainCoffee();
        System.out.println(plainCoffee.getDescription());
        System.out.println(plainCoffee.getCost());

        // Coffee with milk
        Coffee milkCoffee = new MilkDecorator(new PlainCoffee());
        System.out.println(milkCoffee.getDescription());
        System.out.println(milkCoffee.getCost());
    }
}

// What advantages did we get by using this principle
// flexibility, code reuse and clean code without redundancy
// Also we are adhering to open closed principle,
// that states that software entities are open to Extension & Closed to
// modification.