package interfacing;

import TI.BoeBot;
import hardware.sensors.Ultrasone;
import TI.*;

import static TI.PinMode.Input;
import static TI.PinMode.Output;

public class CollisionController {
    private Ultrasone ultrasone;

    public CollisionController() {
        this.ultrasone = new Ultrasone(1, 2);
    }

    public boolean checkEmergencyStop() {
        if (ultrasone.checkDistance() <= 500) {  // change name of the first distance
            return true;
        } else {
            return false;
        }
    }

    public boolean checkNormalStop() {
        if (ultrasone.checkDistance() > 500 && ultrasone.checkDistance() <= 1000) {
            return true;
        }else {
            return false;
        }
    }
}
