package interfacing;

import TI.BoeBot;
import hardware.sensors.Ultrasone;
import TI.*;

import static TI.PinMode.Input;
import static TI.PinMode.Output;

public class CollisionController {
    private Ultrasone ultrasone;
    private Drive drive = new Drive();
    private Timer timer = new Timer(50);

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

    public void checkDistsanceCart() {
        if (this.ultrasone.checkDistance() < 500) {
            drive.emergencyBrake();
        } else if (this.ultrasone.checkDistance() < 1500) {
            drive.getCart();
        } else {
            drive.driveForwardSlowSpeed();
        }
    }
}

