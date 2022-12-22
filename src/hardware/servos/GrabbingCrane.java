package hardware.servos;

import TI.BoeBot;
import TI.PinMode;
import TI.Servo;
import hardware.GripperCallback;
import hardware.Updatable;

public class GrabbingCrane implements Updatable {
    private final Servo servo;
    private int pin;
    private int currentState;
    private int targetState;

    public GrabbingCrane(int pin) {
        this.pin = pin;
        this.servo = new Servo(pin);
        this.currentState = 1495;
        this.targetState = 1500;
        BoeBot.setMode(this.pin, PinMode.Output);
    }

    public void update() {
        if (this.currentState != this.targetState) {
            if (this.currentState < this.targetState)
                this.currentState++;
            if (this.currentState > this.targetState)
                this.currentState--;
            servo.update(currentState);
        }
    }

    public void open() {
        targetState = 2500;
    }

    public void close() {
        targetState = 1400;
    }
}