package Behavioral.CommandMethod;

// This is a behavioral design pattern that converts a request into a stand-alone component called
// command. With this, we can capture each component of a request.

// Lets take a scenario of making a remote control system for a house that can easily handle different 
// device types such as tv, speaker that could be on a house.
// The goal is to design a flexible remote control that can be used to control varied device types.

//command interface
interface Command {
    void execute();
}

// concrete command implementations
class TurnOnCommand implements Command {
    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}

class TurnOffCommand implements Command {
    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}

// receiver interface
interface Device {
    void turnOn();

    void turnOff();
}

// concrete receiver implementations
class TV implements Device {

    @Override
    public void turnOn() {
        System.out.println("TV turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV turned off.");
    }

}

class Speaker implements Device {

    @Override
    public void turnOn() {
        System.out.println("Speaker turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Speaker turned off.");
    }

}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class Solution {
    public static void main(String[] args) {
        TV tv = new TV();
        Speaker speaker = new Speaker();

        // Command objects
        Command turnOnTVCommand = new TurnOnCommand(tv);
        Command turnOffSpeakerCommand = new TurnOffCommand(speaker);

        // remote object
        RemoteControl remote = new RemoteControl();

        // setting the commands and invoking
        remote.setCommand(turnOnTVCommand);
        remote.pressButton();

        remote.setCommand(turnOffSpeakerCommand);
        remote.pressButton();
    }
}
