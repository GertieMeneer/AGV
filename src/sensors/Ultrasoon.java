package sensors;

import TI.BoeBot;

import static TI.PinMode.Input;
import static TI.PinMode.Output;

public class Ultrasoon {

    private int triggerPin;
    private int echoPin;
    private int distance;

    public Ultrasoon(int triggerPin, int echoPin) {
        this.triggerPin = triggerPin;
        this.echoPin = echoPin;
        BoeBot.setMode(triggerPin, Input);
        BoeBot.setMode(echoPin, Output);
    }

    public boolean checkDistance() {
        BoeBot.digitalWrite(echoPin, true);
        BoeBot.wait(1);     //if int pulse = -2 or sensor doesnt work: change this to: BoeBot.uwait(1);
        BoeBot.digitalWrite(echoPin, false);
        int pulse = BoeBot.pulseIn(triggerPin, true, 10000);
        if(pulse < this.distance) {      //1000 is the distance between object and sensor
            return true;
        }
        return false;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }


}
