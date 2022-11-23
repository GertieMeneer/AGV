package sensors;

import TI.BoeBot;

import static TI.PinMode.Input;
import static TI.PinMode.Output;
import static java.lang.Enum.valueOf;

public class Ultrasoon {

    private int triggerPin;
    private int echoPin;
    private int distance;

    public Ultrasoon(int triggerPin, int echoPin, int distance) {
        this.triggerPin = triggerPin;
        this.echoPin = echoPin;
        this.distance = distance;
    }

    public boolean checkDistance() {
        BoeBot.setMode(this.echoPin, Input);
        BoeBot.setMode(this.triggerPin, Output);
        BoeBot.digitalWrite(triggerPin, true);
        BoeBot.uwait(1);
        BoeBot.digitalWrite(triggerPin, false);
        int pulse = BoeBot.pulseIn(echoPin, true, 10000);
        System.out.println(pulse);
        if(pulse < this.distance) {
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
