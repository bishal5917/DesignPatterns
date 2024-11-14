package Structural.BridgeMethod;

// This method is used to separate abstraction from its implementation
// allowing them to vary independently
// Here we are trying to make a remote-control for TV/ radio. There 
// can be two types of remote control- Basic and Advanced
// Advanced can have extra functions for muting

// implementor interface
interface Device {
    void turnOn();

    void turnOff();

    void setVolume(int vol);

    boolean isActive();

    boolean isMuted();
}

// Concrete implementor
class Radio implements Device {

    private int volume = 10;
    private boolean on = false;

    @Override
    public void turnOn() {
        on = true;
    }

    @Override
    public void turnOff() {
        on = false;
    }

    @Override
    public void setVolume(int vol) {
        this.volume = vol;
    }

    @Override
    public boolean isActive() {
        return on;
    }

    @Override
    public boolean isMuted() {
        return volume == 0;
    }

}

// Concrete implementor
class TV implements Device {

    private int volume = 10;
    private boolean on = false;

    @Override
    public void turnOn() {
        on = true;
    }

    @Override
    public void turnOff() {
        on = false;
    }

    @Override
    public void setVolume(int vol) {
        this.volume = vol;
    }

    @Override
    public boolean isActive() {
        return on;
    }

    @Override
    public boolean isMuted() {
        return volume == 0;
    }

}

// Defining the remote control abstraction
abstract class RemoteControl {
    public Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void togglePower() {
        if (device.isActive()) {
            device.turnOff();
        } else {
            device.turnOn();
        }
    }

    public void setVolume(int vol) {
        device.setVolume(vol);
    }
}

// Now implement the BasicRemote and AdvancedRemote
class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }
}

class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
        System.out.println("Device is muted");
    }
}

public class Solution {
    public static void main(String[] args) {
        Device radio = new Radio();
        Device tv = new TV();
        // Now lets operate tv using basic remote
        RemoteControl basicControl = new BasicRemote(tv);
        basicControl.setVolume(5);
        basicControl.togglePower();
        System.out.println(basicControl.device.isMuted());
        System.out.println(basicControl.device.isActive());

        // Now lets operate a radio using advanced remote
        RemoteControl advancedControl = new AdvancedRemote(radio);
        // advancedControl.setVolume(5);
        advancedControl.togglePower();
        ((AdvancedRemote) advancedControl).mute();
        System.out.println(advancedControl.device.isMuted());
        System.out.println(advancedControl.device.isActive());
    }
}
