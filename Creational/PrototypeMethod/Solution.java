package Creational.PrototypeMethod;

interface Shape {
    Shape clone(); // creates a copy of itself

    void draw(); // draw the shape
}

class Circle implements Shape {

    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public Shape clone() {
        return new Circle(this.color);
    }

    @Override
    public void draw() {
        System.out.println("Drawn a circle with " + this.color + " color");
    }
}

class ShapeClient {

    private Shape shapePrototype;

    public ShapeClient(Shape shapePrototype) {
        this.shapePrototype = shapePrototype;
    }

    public Shape createShape() {
        return shapePrototype.clone();
    }
}

public class Solution {

    public static void main(String[] args) {
        // Now lets create a circle prototype
        Circle circle = new Circle("red");
        ShapeClient shapeClient = new ShapeClient(circle);
        Shape redCircle = shapeClient.createShape();
        redCircle.draw();
    }

}
