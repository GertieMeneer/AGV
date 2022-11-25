package application;

import TI.BoeBot;
import TI.Timer;
import hardware.additional.NeoPixel;
import hardware.sensors.Ultrasone;
import interfacing.Drive;
import hardware.servos.GrabbingCrane;

public class Demo1 {
    public static void main(String[] args) {
        new Demo1();

//        distanceDrivingDemo();          //demo for driving and stopping when object
//        BoeBot.wait(1000);
//        grabingCraneDemo();             //demo for grabingcrane: opening/closing slowely and fast
//        Wheel.ForwardAcceleratingMaxSpeed();
//        distanceDrivingDemo();
    }

    public Demo1() {
        distanceDrivingDemo();
    }

    public void distanceDrivingDemo() {
        Drive drive = new Drive();

        Timer t1 = new Timer(750);
        Timer t2 = new Timer(1000);
        Ultrasone ultrasoon = new Ultrasone(1, 0, 1000);

        while (true) {
            if (!ultrasoon.checkDistance()) {
                if(t1.timeout()) {
                    NeoPixel.allBlack();
                    NeoPixel.forwardWhite();
                    drive.driveForwardSlowSpeed();
                }
            } else {
                drive.emergencyBrake();
                NeoPixel.allRed();
                t1.mark();
            }
            drive.update();
            BoeBot.wait(1);
        }
    }

    public void grabingCraneDemo() {
        GrabbingCrane crane = new GrabbingCrane(14);
        crane.open();
        BoeBot.wait(1000);
        crane.slowlyClose();
        BoeBot.wait(1000);
        crane.slowlyOpen();
        BoeBot.wait(1000);
        crane.close();
        BoeBot.wait(1000);
    }
}



