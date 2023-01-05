package interfacing;

import TI.Servo;
import hardware.GripperCallback;
import hardware.servos.GrabbingCrane;

public class Crane{
    private GrabbingCrane crane;
    private int pin;
    private boolean open;

    public Crane(int pin) {
        this.pin = pin;
        this.crane = new GrabbingCrane(14);
    }

    public void update(){
        crane.update();
    }
}
