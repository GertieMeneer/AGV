package interfacing;

import TI.Servo;
import hardware.servos.GrabbingCrane;

public class Crane {
    private GrabbingCrane crane;
    private int pin;
    private boolean open;

    public Crane(int pin) {
        this.pin = pin;
//        this.crane = new GrabbingCrane(this.pin);
    }

    public void open() {
//        crane.setTargetAngle(1000);
        open = true;
    }

    public void close() {
//        crane.setTargetAngle(1);
        open = false;
    }

    public boolean getStatus() {
        return open;
    }

//    public void setOpen() {
//        Servo s1 = new Servo(14);
//        s1.update(0);
//
//    }
}
