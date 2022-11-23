package sensors;

import TI.BoeBot;

import static TI.PinMode.Input;
import static TI.PinMode.Output;

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
        BoeBot.setMode(this.echoPin, Input);                        //setting pinmodes, doesnt work in constructor
        BoeBot.setMode(this.triggerPin, Output);

        BoeBot.digitalWrite(triggerPin, true);                  //generating pulse
        BoeBot.uwait(1);
        BoeBot.digitalWrite(triggerPin, false);
        int pulse = BoeBot.pulseIn(echoPin, true, 10000);   //reading pulse, future update: calculating distance in cm
        System.out.println(pulse);                                  //printing pulse for debugging/information
        if(pulse < this.distance) {                                 //returning true or false depending on distance
            return true;
        }                                                           //lets method know if there is an object when it calls this method
        return false;
        }

    public void setDistance(int distance) {                         //for changing distance if needed
        this.distance = distance;
    }

    public int getDistance() {                                      //for getting distance if needed
        return this.distance;
    }


}
