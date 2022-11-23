import TI.BoeBot;
import TI.Servo;
import additional.LED;
import sensors.Ultrasoon;
import servos.Wheel;

import static TI.PinMode.Input;
import static TI.PinMode.Output;

public class Main {
    public static void main(String[] args) {

        while(true) {
            testMethode();
        }
    }

    public static void testMethode() {
        boolean driving = false;

        Ultrasoon ultrasoon = new Ultrasoon(1, 0, 2000);

        LED errorLED = new LED(8,  true);

//        Wheel rightWheel = new Wheel(12);
//        Wheel leftWheel = new Wheel(13);

        Servo rightWheel = new Servo(12);
        Servo leftWheel = new Servo(13);

        if(!ultrasoon.checkDistance()) {
            if(!driving) {
                rightWheel.update(2000);
                leftWheel.update(1000);
                driving = true;
            }
            errorLED.Set(true);
        } else {
            rightWheel.update(1500);
            leftWheel.update(1500);
            driving = false;
            errorLED.Set(false);
        }

        BoeBot.wait(500);
    }
}