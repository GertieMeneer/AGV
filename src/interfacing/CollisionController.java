package interfacing;

import TI.BoeBot;
import hardware.sensors.Ultrasone;
import TI.*;
import static TI.PinMode.Input;
import static TI.PinMode.Output;

public class CollisionController {
    private Ultrasone ultrasone;

    public CollisionController() {
        this.ultrasone = new Ultrasone(1,2);
    }

    public boolean checkEmergency(){
        ultrasone.setDistance(1000);
        if (ultrasone.checkDistance() <= ultrasone.getDistance()){  // change name of the first distance
            return true;
        }else{
            return false;
        }
    }

}
