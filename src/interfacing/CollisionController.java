package interfacing;

import TI.BoeBot;
import hardware.sensors.Ultrasone;
import TI.*;
import static TI.PinMode.Input;
import static TI.PinMode.Output;

public class CollisionController {
    private Ultrasone ultrasone;
    private int distance;
    private int distanceBorder;

    public CollisionController() {
        this.ultrasone = new Ultrasone(0,1, 1000);
    }

    public boolean isClose(){

        if (this.distance <= ultrasone.getDistance()){  // change name of the first distance
            return true;
        }else{
            return false;
        }
    }

}
