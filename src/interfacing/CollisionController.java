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
    private Crane crane = new Crane(14);

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
        System.out.println(this.ultrasone);
        if (this.ultrasone.checkDistance() < 500) {
            drive.emergencyBrake();
        } else if (this.ultrasone.checkDistance() < 1500) {
            crane.open();
            BoeBot.wait(1000);
            crane.close();
        } else {
            drive.driveForwardSlowSpeed();
        }
    }
}

