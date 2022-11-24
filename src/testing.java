import TI.BoeBot;
import TI.Servo;
import hardware.additional.LED;
import hardware.sensors.Ultrasoon;

import static TI.PinMode.Output;

public class testing {
    public static void main(String[] args) {
        BoeBot.setMode(8, Output);

        while (true) {
            testMethodDetectingObject();
        }
    }

    public static void testMethodDetectingObject() {
        boolean updatable = true;


        Ultrasoon ultrasoon = new Ultrasoon(1, 0, 2000);

        LED errorLED = new LED(8, true);


        Servo rightWheel = new Servo(12);
        Servo leftWheel = new Servo(13);

        if (!ultrasoon.checkDistance()) {
            if (updatable) {
                rightWheel.update(2000);
                leftWheel.update(1000);
                updatable = false;
            }
            errorLED.Set(false);
        } else {
            rightWheel.update(1500);
            leftWheel.update(1500);
            updatable = true;
            errorLED.Set(true);
        }
        BoeBot.wait(100);
    }
}

