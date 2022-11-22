package sensors;

import TI.BoeBot;

import static TI.PinMode.Input;
import static TI.PinMode.Output;

public class Ultrasoon {

    private int triggerPin;
    private int echoPin;

    public Ultrasoon(int triggerPin, int echoPin) {
        this.triggerPin = triggerPin;
        this.echoPin = echoPin;
        BoeBot.setMode(triggerPin, Input);
        BoeBot.setMode(echoPin, Output);
    }

    private boolean checkDistance() {
        BoeBot.digitalWrite(echoPin, true);
        BoeBot.wait(1);
        BoeBot.digitalWrite(echoPin, false);
        int pulse = BoeBot.pulseIn(triggerPin, true, 10000);
        if(pulse < 1000) {      //1000 is the distance between object and sensor
            return true;
        }
        return false;
    }


}
