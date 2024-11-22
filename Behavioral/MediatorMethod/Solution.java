package Behavioral.MediatorMethod;

// This pattern is used in the situation where we have large number of objects in our program.
// And we want to centralize the communication between these objects
// This promotes loose coupling by preventing direct interactions between the components.
// It is one of the most important and widely used design pattern.

//Interface
interface Airplane {
    void requestTakeOff();

    void requestLanding();

    void notifyAirTrafficControl(String message);
}

class CommercialAirplane implements Airplane {
    private AirTrafficControlTower mediator;

    public CommercialAirplane(AirTrafficControlTower mediator) {
        this.mediator = mediator;
    }

    @Override
    public void requestTakeOff() {
        mediator.requestTakeOff(this);
    }

    @Override
    public void requestLanding() {
        mediator.requestLanding(this);
    }

    @Override
    public void notifyAirTrafficControl(String message) {
        System.out.println("Commericial airplane: " + message);
    }
}

// Mediator interface
interface AirTrafficControlTower {
    void requestTakeOff(Airplane airplane);

    void requestLanding(Airplane airplane);
}

// concrete mediator
class AirportControlTower implements AirTrafficControlTower {

    @Override
    public void requestTakeOff(Airplane airplane) {
        airplane.notifyAirTrafficControl("Requesting airport clearance");
    }

    @Override
    public void requestLanding(Airplane airplane) {
        airplane.notifyAirTrafficControl("Requesting landing clearance");
    }

}

public class Solution {
    public static void main(String[] args) {
        // Instantiate the mediator
        AirTrafficControlTower airportControlTower = new AirportControlTower();

        // Instantiate concrete colleagues
        Airplane airplane1 = new CommercialAirplane(airportControlTower);
        Airplane airplane2 = new CommercialAirplane(airportControlTower);

        // setup the association between them
        airplane1.requestTakeOff();
        airplane2.requestLanding();
    }

}
