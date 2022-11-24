package hardware.servos;

import TI.*;
import hardware.additional.NeoPixels;

public class Wheel {

    public static void driveForwardFullSpeed() {
        Servo rightWheel = new Servo(12);
        Servo leftWheel = new Servo(13);

        rightWheel.update(2000);
        leftWheel.update(1000);
        NeoPixels.forwardWhite();
    }

    public static void driveForwardSlowSpeed() {
        Servo rightWheel = new Servo(12);
        Servo leftWheel = new Servo(13);

        rightWheel.update(1540);
        leftWheel.update(1460);
        NeoPixels.forwardWhite();
    }

    public static void emergencyBrake() {
        Servo rightWheel = new Servo(12);
        Servo leftWheel = new Servo(13);

        rightWheel.update(1500);
        leftWheel.update(1500);
        NeoPixels.allRed();
    }

    public static void ForwardAcceleratingMaxSpeed() {
        Servo rightWheel = new Servo(12);
        Servo leftWheel = new Servo(13);

        for (int i = 0; i < 500; i++) {
            rightWheel.update(1500+i);
            leftWheel.update(1500-i);
            BoeBot.wait(75);
        }
    }
}
