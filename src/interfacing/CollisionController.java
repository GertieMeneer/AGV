package interfacing;

import TI.BoeBot;
import hardware.sensors.Ultrasone;
import TI.*;

import static TI.PinMode.Input;
import static TI.PinMode.Output;

public class CollisionController {
    private Ultrasone ultrasone;
    private Drive drive = new Drive();
    private int pulseTranslation;

    public CollisionController() {
        this.ultrasone = new Ultrasone(11, 10);
    }

    public void checkDistance() {
        this.pulseTranslation = ultrasone.checkDistance();
        if(pulseTranslation < 500) {
            drive.emergencyBrake();
        } else if (pulseTranslation < 1500) {
            drive.slowStop();
        } else {
            drive.driveForwardSlowSpeed();
        }
    }
}
