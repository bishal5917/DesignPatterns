
abstract class Vehicle {
    public abstract void printVehicle();
}

class TwoWheeler extends Vehicle {

    @Override
    public void printVehicle() {
        System.out.println("Two Wheeler");
    }
}

class FourWheeler extends Vehicle {

    @Override
    public void printVehicle() {
        System.out.println("Four Wheeler");
    }
}

interface VechicleFactory {
    public Vehicle createVehicle();
}

class TwoWheelerFactory implements VechicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}

class FourWheelerFactory implements VechicleFactory {

    @Override
    public Vehicle createVehicle() {
        return new FourWheeler();
    }
}

class SolutionClient {
    private Vehicle vehicle;

    public SolutionClient(VechicleFactory vFactory) {
        vehicle = vFactory.createVehicle();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}

public class Solution {
    public static void main(String[] args) {
        VechicleFactory twoWheelerFactory = new TwoWheelerFactory();
        SolutionClient client = new SolutionClient(twoWheelerFactory);
        Vehicle twoWheeler = client.getVehicle();
        twoWheeler.printVehicle();
    }
}
