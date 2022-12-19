package interfacing;

import hardware.Updatable;
import hardware.WheelCallback;
import hardware.servos.Wheel;

import java.util.Timer;

public class Drive implements WheelCallback {
    private Wheel rightWheel;
    private Wheel leftWheel;
    private NotificationsController neopixels = new NotificationsController();

    public Drive() {
        rightWheel = new Wheel(12, this);
        leftWheel = new Wheel(13, this);
    }

    public void setSpeed(int speed) {
        rightWheel.setSpeed(speed);
        leftWheel.setSpeed(-speed);
    }

    public void setTargetSpeed(int speed) {
        rightWheel.setTargetSpeed(speed);
        leftWheel.setTargetSpeed(-speed);
    }


    public void setSpeedForward(int speed) {
        rightWheel.setTargetSpeed(speed);
        leftWheel.setTargetSpeed(-speed);
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
        rightWheel.setSpeed(100);
        leftWheel.setSpeed(0);
    }

    public void left() {
        rightWheel.setSpeed(0);
        leftWheel.setSpeed(-1000);
    }

    public void slowStop() {
        rightWheel.setTargetSpeed(0);
        leftWheel.setTargetSpeed(0);
    }

    public boolean checkTargetSpeed() {
        return rightWheel.getTargetSpeed() == rightWheel.getCurrentSpeed() && leftWheel.getCurrentSpeed() == leftWheel.getTargetSpeed();
    }

    @Override
    public void onTarget() {
        System.out.println("reached targerSpeed");
    }
}