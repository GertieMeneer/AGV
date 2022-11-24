package hardware.servos;

import TI.*;

public class Wheel {
    private int GPIOpin;
    private Servo wheel = new Servo(this.GPIOpin);



    public Wheel(int GPIOpin) {
        this.GPIOpin = GPIOpin;
    }

    public static void driveForwardFullSpeed() {
        Servo rightWheel = new Servo(12);
        Servo leftWheel = new Servo(13);

        rightWheel.update(2000);
        leftWheel.update(1000);
    }

    public static void driveForwardSlowSpeed() {
        Servo rightWheel = new Servo(12);
        Servo leftWheel = new Servo(13);

        rightWheel.update(1540);
        leftWheel.update(1460);
    }

    public static void emergencyBrake() {
        Servo rightWheel = new Servo(12);
        Servo leftWheel = new Servo(13);

        rightWheel.update(1500);
        leftWheel.update(1500);
    }
}
