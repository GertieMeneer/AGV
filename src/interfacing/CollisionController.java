package interfacing;

import TI.BoeBot;
import hardware.sensors.Ultrasone;
import TI.*;

import static TI.PinMode.Input;
import static TI.PinMode.Output;

public class CollisionController {
    private Ultrasone ultrasone;
    private Drive drive = new Drive();

    public CollisionController() {
        this.ultrasone = new Ultrasone(11, 10);
    }

    public void stopClose() {
        if (this.ultrasone.checkDistance() <= 500) {  // change name of the first distance
           this.drive.emergencyBrake();
        }
    }

    public void stopFar() {
        if (this.ultrasone.checkDistance() > 500 && this.ultrasone.checkDistance() <= 1000) {
            this.drive.slowStop();
        }
    }
}
