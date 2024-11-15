package Structural.FacadeMethod;

// The facade method provides an interface for the client to use the subsystems
// Eliminating the tedious task of handling individual sub-systems

// Lets take a scenario of a Home studio of a music producer
// There can be various gadgets in a home studio,
// By using this facade method, we create a Facade class to handle the setup of a home studio 
// While starting a producing session and a setup to close the studio, when the producing session has finished
abstract class StudioGear {
    public abstract void turnOn();

    public abstract void connect();

    public abstract void setVolume(int vol);

    public abstract void mute();

    public abstract void turnOff();

    public abstract void disconnect();
}

class HeadPhones extends StudioGear {

    @Override
    public void turnOn() {
        System.out.println("Headphones turned on");
    }

    @Override
    public void connect() {
        System.out.println("Headphones connected");
    }

    @Override
    public void setVolume(int vol) {
        System.out.println("Headphones volume set");
    }

    @Override
    public void mute() {
        System.out.println("Headphones muted");
    }

    @Override
    public void turnOff() {
        System.out.println("Headphones turned off");
    }

    @Override
    public void disconnect() {
        System.out.println("Headphones disconnected");
    }
}

class LaunchPad extends StudioGear {

    @Override
    public void turnOn() {
        System.out.println("Launchpad turned on");
    }

    @Override
    public void connect() {
        System.out.println("Launchpad connected");
    }

    @Override
    public void setVolume(int vol) {
        System.out.println("Launchpad volume set");
    }

    @Override
    public void mute() {
        System.out.println("Launchpad muted");
    }

    @Override
    public void turnOff() {
        System.out.println("Launchpad turned off");
    }

    @Override
    public void disconnect() {
        System.out.println("Launchpad disconnected");
    }
}

class Woofer extends StudioGear {

    @Override
    public void turnOn() {
        System.out.println("Woofer turned on");
    }

    @Override
    public void connect() {
        System.out.println("Woofer connected");
    }

    @Override
    public void setVolume(int vol) {
        System.out.println("Woofer volume set");
    }

    @Override
    public void mute() {
        System.out.println("Woofer muted");
    }

    @Override
    public void turnOff() {
        System.out.println("Woofer turned off");
    }

    @Override
    public void disconnect() {
        System.out.println("Woofer disconnected");
    }
}

// NOW THE FACADE CLASS
class HomeStudioFacade {
    private HeadPhones headPhones;
    private LaunchPad launchPad;
    private Woofer woofer;

    public HomeStudioFacade(HeadPhones headPhones, LaunchPad launchPad, Woofer woofer) {
        this.headPhones = headPhones;
        this.launchPad = launchPad;
        this.woofer = woofer;
    }

    public void startProducingSession() {
        System.out.println("*** STARTING THE PRODUCING SESSION ***");
        headPhones.turnOn();
        headPhones.connect();
        headPhones.setVolume(7);
        launchPad.turnOn();
        launchPad.connect();
        woofer.turnOn();
        woofer.connect();
        woofer.setVolume(7);
    }

    public void muteStudio() {
        System.out.println("$$$ STUDIO MUTED $$$");
        headPhones.mute();
        launchPad.mute();
        woofer.mute();
    }

    public void endProducingSession() {
        System.out.println("*** ENDING THE PRODUCING SESSION ***");
        headPhones.disconnect();
        headPhones.turnOff();
        launchPad.disconnect();
        launchPad.turnOff();
        woofer.disconnect();
        woofer.turnOff();
    }
}

public class Solution {

    public static void main(String[] args) {
        // We declare our studio gears
        HeadPhones headPhones = new HeadPhones();
        LaunchPad launchPad = new LaunchPad();
        Woofer woofer = new Woofer();

        // we declare our facade
        HomeStudioFacade homeStudio = new HomeStudioFacade(headPhones, launchPad, woofer);
        homeStudio.startProducingSession();
        homeStudio.endProducingSession();
    }
}
