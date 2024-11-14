package Structural.AdapterMethod;

// All shapes must use this interface
interface Shape {
    public void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Cirlce Drawn");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle Drawn");
    }
}

// Adaptee (We need to adapt this class)
class Triangle {
    public void render() {
        System.out.println("Triangle Rendered");
    }
}

// We need to create an adapter so that
// Triangle can use the shape interface
class TriangleAdapter implements Shape {
    private Triangle triangle;

    public TriangleAdapter(Triangle triangle) {
        this.triangle = triangle;
    }

    @Override
    public void draw() {
        triangle.render();
    }
}

public class Solution {

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        Shape triangleAdapter = new TriangleAdapter(triangle);
        circle.draw();
        rectangle.draw();
        triangleAdapter.draw();
    }
}

// Here, we used a TriangleAdapter to adapt the Triangle class to use the Shape
// interface
// This introduced loose coupling as Triangle doesnot need to know about the
// Shape interface
// and Shape interface doesnot need to know about TriangleAdapter
