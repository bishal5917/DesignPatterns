
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

class Client {

    private Vehicle vehicle;

    public Client(int type) {
        if (type == 0) {
            vehicle = new TwoWheeler();
        } else if (type == 1) {
            vehicle = new FourWheeler();
        } else {
            vehicle = null;
        }
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}

public class Problem {
    public static void main(String[] args) {
        Client client = new Client(1);
        Vehicle vehicle = client.getVehicle();
        vehicle.printVehicle();
    }
}

// The problems here are:
// 1. The client class directly creates the vehicle based on input leading to
// strong dependency
// 2. The client class handles its own lifecycle in addition to the creation of
// vehicle class, which is incorrect
// according to the principle that software enties must have a single reason to
// change
// 3. In order to add a new vehicle type, we have to modify the CLient class
// here, which goes against the principle
// that software entities must be closed for modification and open for extension