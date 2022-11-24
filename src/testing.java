import TI.BoeBot;
import TI.Servo;
import additional.LED;
import sensors.Ultrasoon;

import static TI.PinMode.Output;

public class testing {
    public static void main(String[] args) {
        BoeBot.setMode(8, Output);

        while (true) {
            testMethodDetectingObject();
        }
    }

        public static void testMethodDetectingObject() {
            boolean driving = false;


            Ultrasoon ultrasoon = new Ultrasoon(1, 0, 2000);

            LED errorLED = new LED(8,  true);

//        Wheel rightWheel = new Wheel(12);
//        Wheel leftWheel = new Wheel(13);
            // wheel klasse werkt nog niet echt for some reason

            Servo rightWheel = new Servo(12);
            Servo leftWheel = new Servo(13);

            if(!ultrasoon.checkDistance()) {
                if(!driving) {
                    rightWheel.update(2000);
                    leftWheel.update(1000);
                    driving = true;
                }
                errorLED.Set(false);
            } else {
                rightWheel.update(1500);
                leftWheel.update(1500);
                driving = false;
                errorLED.Set(true);
            }
            BoeBot.wait(100);
        }
    }

