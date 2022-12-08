package interfacing;

import TI.BoeBot;
import hardware.sensors.Ultrasone;
import TI.*;

import static TI.PinMode.Input;
import static TI.PinMode.Output;

public class CollisionController {
    private Ultrasone ultrasone;
    private Drive drive = new Drive();
    //    private Timer t1 = new Timer(5000);
//    private Timer t2 = new Timer(1000);
    private Crane crane = new Crane(14);

    public CollisionController() {
        this.ultrasone = new Ultrasone(11, 10);
    }

    public void checkDistance() {
        System.out.println(this.ultrasone.checkDistance());
        if (this.ultrasone.checkDistance() < 500) {
            drive.emergencyBrake();
        } else if (this.ultrasone.checkDistance() < 1500) {
            drive.slowStop();
        } else {
            drive.driveForwardSlowSpeed();
        }
    }
}

