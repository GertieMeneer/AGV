package hardware.sensors;

import TI.BoeBot;

import static TI.PinMode.Input;
import static TI.PinMode.Output;

public class Ultrasone {

    private int triggerPin;
    private int echoPin;
    private int distance;

    public Ultrasone(int triggerPin, int echoPin) {
        this.triggerPin = triggerPin;
        this.echoPin = echoPin;
        this.distance = distance;
    }


    public int checkDistance() {
        BoeBot.setMode(this.echoPin, Input);                        //setting pinmodes, doesnt work in constructor
        BoeBot.setMode(this.triggerPin, Output);

        BoeBot.digitalWrite(triggerPin, true);                  //generating pulse
        BoeBot.uwait(1);
        BoeBot.digitalWrite(triggerPin, false);

        int pulse = BoeBot.pulseIn(echoPin, true, 10000);   //reading pulse, future update: calculating distance in cm
        System.out.println(pulse);                                  //printing pulse for debugging/information

        return pulse;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

}
