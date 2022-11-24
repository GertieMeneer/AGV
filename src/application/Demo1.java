package application;

import TI.BoeBot;
import TI.Servo;
import hardware.additional.NeoPixels;
import hardware.sensors.Ultrasoon;
import hardware.servos.GrabingCrane;

public class Demo1 {
    public static void main(String[] args) {
        distanceDrivingDemo();          //demo for driving and stopping when object
//        BoeBot.wait(1000);
//        grabingCraneDemo();             //demo for grabingcrane: opening/closing slowely and fast
    }

    public static void distanceDrivingDemo() {
        boolean driving = false;
        Ultrasoon ultrasoon = new Ultrasoon(1, 0, 1000);

        Servo rightWheel = new Servo(12);
        Servo leftWheel = new Servo(13);
        while (true) {
            if (!ultrasoon.checkDistance()) {
                    rightWheel.update(2000);
                    leftWheel.update(1000);
                    NeoPixels.allBlack();
                    NeoPixels.forwardWhite();
            } else {
                rightWheel.update(1500);
                leftWheel.update(1500);
                NeoPixels.allRed();
            }
            BoeBot.wait(100);
        }
    }

    public static void grabingCraneDemo() {
        GrabingCrane.open();
        BoeBot.wait(1000);
        GrabingCrane.slowlyClose();
        BoeBot.wait(1000);
        GrabingCrane.slowlyOpen();
        BoeBot.wait(1000);
        GrabingCrane.close();
        BoeBot.wait(1000);
    }
}



