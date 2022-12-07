package interfacing;

import TI.Servo;
import hardware.Updatable;
import hardware.servos.GrabbingCrane;

public class Crane {
    private GrabbingCrane crane;
    private int pin;

    public Crane(int pin) {
        this.pin = pin;
        this.crane = new GrabbingCrane(this.pin);
    }

    public void open() {
        crane.setTargetAngle(1000);
    }

    public void close() {
        crane.setTargetAngle(1);
    }

    public void setOpen() {
        Servo s1 = new Servo(14);
        s1.update(0);

    }
}
