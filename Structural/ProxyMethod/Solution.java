package Structural.ProxyMethod;

// Proxy = surrogate (substitute)
// Proxy = A person holding an authority to act for another.
// Proxy design pattern is a way of using an object to control
// access to the another object. Using a placeholder object
// We can also say that the client and the main object are connected by the
// proxy object. The client communicates with the proxy rather than with the main object.
// The proxy can take care of additional tasks like logging, caching, security & Lazy Loading. 

// Consider a case where we are required to load an image from the disk and we are required to 
// also optimize the image displaying process.

// subject (Interface or abstract class)

interface Image {
    public void display();
}

// Real subject : Image
class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }

    public void loadImageFromDisk() {
        System.out.println("Loading image " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying the image " + fileName);
    }
}

// Intermediate Object or Proxy
class ProxyImage implements Image {

    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        // Only create a new realImage if its null (Memory Optimization)
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

public class Solution {
    public static void main(String[] args) {
        ProxyImage img = new ProxyImage("Dog.jpg");
        // for the first time, it will get loaded first and then will get displayed
        img.display();
        // Here it gets displayed as the loaded one is cached by the Proxy
        img.display();
    }
}
