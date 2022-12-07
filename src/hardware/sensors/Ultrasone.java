package hardware.sensors;

import TI.BoeBot;

import static TI.PinMode.Input;
import static TI.PinMode.Output;

public class Ultrasone {

    private int triggerPin;
    private int echoPin;

    public Ultrasone(int triggerPin, int echoPin) {

        this.triggerPin = triggerPin;
        this.echoPin = echoPin;

        BoeBot.setMode(this.echoPin, Input);                        //setting pinmodes, doesnt work in constructor
        BoeBot.setMode(this.triggerPin, Output);
    }


    public int checkDistance() {
        BoeBot.digitalWrite(triggerPin, true);                  //generating pulse
        BoeBot.uwait(1);
        BoeBot.digitalWrite(triggerPin, false);

        int pulse = BoeBot.pulseIn(this.echoPin, true, 10000);   //reading pulse, future update: calculating distance in cm
        System.out.println(pulse);


        return pulse;
    }



}
