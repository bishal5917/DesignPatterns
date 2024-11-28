package Behavioral.StateMethod;

// State method allows an object to alter its behaviour when its internal state changes.

// Imagine a vending machine that sells various products. The vending machine needs to manage 
// various states such as ready to serve, waiting for product selection, processing payment,
// and handling out-of-stock situations. We gotta design a system that models this system of the device perfectly.

interface VendingMachineState {
    void handleRequest();
}

class ReadyState implements VendingMachineState {

    @Override
    public void handleRequest() {
        System.out.println("READY");
    }

}

class ProductSelectedState implements VendingMachineState {

    @Override
    public void handleRequest() {
        System.out.println("PRODUCT SELECTED");
    }

}

class PaymentPendingState implements VendingMachineState {

    @Override
    public void handleRequest() {
        System.out.println("PAYMENT PENDING");
    }

}

class OutOfStockState implements VendingMachineState {

    @Override
    public void handleRequest() {
        System.out.println("OUT OF STOCK");
    }

}

class VendingMachineContext {
    private VendingMachineState state;

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void request() {
        state.handleRequest();
    }
}

public class Solution {
    public static void main(String[] args) {
        // Create the overall context
        VendingMachineContext machine = new VendingMachineContext();

        // Now we explore the states
        machine.setState(new ReadyState());
        machine.request();

        machine.setState(new ProductSelectedState());
        machine.request();

        machine.setState(new PaymentPendingState());
        machine.request();

        machine.setState(new OutOfStockState());
        machine.request();
    }
}
