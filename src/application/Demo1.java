package application;

import TI.BoeBot;
import TI.Servo;
import TI.Timer;
import hardware.additional.NeoPixels;
import hardware.sensors.Ultrasoon;
import hardware.servos.GrabingCrane;
import hardware.servos.Wheel;

public class Demo1 {
    public static void main(String[] args) {
        distanceDrivingDemo();          //demo for driving and stopping when object
//        BoeBot.wait(1000);
//        grabingCraneDemo();             //demo for grabingcrane: opening/closing slowely and fast
    }

    public static void distanceDrivingDemo() {
        Timer t1 = new Timer(1000);
        boolean driving = false;
        Ultrasoon ultrasoon = new Ultrasoon(1, 0, 1000);

        while (true) {
            if (!ultrasoon.checkDistance()) {
                if(t1.timeout()) {
                    Wheel.driveForwardSlowSpeed();
                    NeoPixels.allBlack();
                    NeoPixels.forwardWhite();
                }
            } else {
                Wheel.emergencyBrake();
                NeoPixels.allRed();
                t1.mark();
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



