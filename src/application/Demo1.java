package application;

import TI.BoeBot;
import TI.Servo;
import hardware.additional.LED;
import hardware.sensors.Ultrasoon;
import hardware.servos.GrabingCrane;

import java.awt.*;

public class Demo1 {
    public static void main(String[] args) {
        distanceDrivingDemo();          //demo for driving and stopping when object
//        BoeBot.wait(1000);
//        grabingCraneDemo();             //demo for grabingcrane: opening/closing slowely and fast
    }

    public static void distanceDrivingDemo() {
        boolean driving = false;        //pretty much useless, morgen ff checken
        Ultrasoon ultrasoon = new Ultrasoon(1, 0, 1000);
//        LED errorLED = new LED(8, true);

        Servo rightWheel = new Servo(12);
        Servo leftWheel = new Servo(13);
        while (true) {
            if (!ultrasoon.checkDistance()) {
                if (!driving) {
                    rightWheel.update(2000);
                    leftWheel.update(1000);
                    for (int i = 0; i < 6; i++) {
                        BoeBot.rgbSet(i, Color.black);
                    }
                    BoeBot.rgbShow();
                }
//                errorLED.Set(false);
            } else {
                rightWheel.update(1500);
                leftWheel.update(1500);
                driving = false;
//                errorLED.Set(true);
                for (int i = 0; i < 6 ; i++) {
                    BoeBot.rgbSet(i, Color.red);
                }
                BoeBot.rgbShow();

            }
            BoeBot.wait(100);
        }
    }

//    public static void grabingCraneDemo() {
//        GrabingCrane.open();
//        BoeBot.wait(1000);
//        GrabingCrane.slowlyClose();
//        BoeBot.wait(1000);
//        GrabingCrane.slowlyOpen();
//        BoeBot.wait(1000);
//        GrabingCrane.close();
//        BoeBot.wait(1000);
//    }
}



