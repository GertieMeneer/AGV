package interfacing;

import TI.BoeBot;
import TI.Servo;
import hardware.servos.GrabbingCrane;
import hardware.servos.Updatelble;
import hardware.servos.Wheel;

public class Drive implements Updatelble {
    private Wheel rightWheel;
    private Wheel leftWheel;
    private NotificationsController neopixels = new NotificationsController();
    private Crane crane = new Crane(14);

    public Drive() {
        rightWheel = new Wheel(12);
        leftWheel = new Wheel(13);
    }


    public void setSpeedForward(int speed) {
        rightWheel.setTargetSpeed(speed);
        leftWheel.setTargetSpeed(-speed);
        update();
    }

    public void slowSpeedforward () {
        rightWheel.setTargetSpeed(50);
        leftWheel.setTargetSpeed(-50);
    }

    public void update() {
        rightWheel.update();
        leftWheel.update();
    }

    public void emergencyBrake() {
        rightWheel.setSpeed(0);
        leftWheel.setSpeed(0);
    }

    public void right() {
        rightWheel.setSpeed(50);
        leftWheel.setSpeed(0);
    }

    public void left() {
        rightWheel.setSpeed(0);
        leftWheel.setSpeed(-50);
    }

    public void open() {
        ;
    }

    public void close() {

    }
}