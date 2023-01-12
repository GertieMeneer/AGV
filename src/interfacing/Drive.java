package interfacing;

import TI.BoeBot;
import hardware.Updatable;
import hardware.WheelCallback;
import hardware.servos.Wheel;

import java.text.Normalizer;
import java.util.Timer;

public class Drive implements WheelCallback {
    private Wheel rightWheel;
    private Wheel leftWheel;
    private NotificationsController neopixels;

    public Drive() {
        rightWheel = new Wheel(12, this);
        leftWheel = new Wheel(13, this);
        neopixels = new NotificationsController();
    }

    public void setSpeed(int speed) {
        if(speed > 0) {
            neopixels.forwardWhite();
        } else if(speed < 0) {
            neopixels.backwardsWhite();
        } else {
            neopixels.allRed();
        }
        rightWheel.setSpeed(speed);
        leftWheel.setSpeed(-speed);
    }

    private void setTargetSpeed(int speed) {
        if(speed < 0) {
            neopixels.backwardsWhite();
        } else if(speed > 0) {
            neopixels.forwardWhite();
        } else {
            neopixels.allRed();
        }
        rightWheel.setTargetSpeed(speed);
        leftWheel.setTargetSpeed(-speed);
    }

    public void slowSpeedforward () {
        neopixels.forwardWhite();
        rightWheel.setTargetSpeed(20);
        leftWheel.setTargetSpeed(-20);
    }

    public void slowSpeedbackward () {
        neopixels.backwardsWhite();
        rightWheel.setTargetSpeed(-20);
        leftWheel.setTargetSpeed(20);
    }

    public void update() {
        rightWheel.update();
        System.out.println("Right currentspeed: " + rightWheel.getCurrentSpeed());
        System.out.println("Right targetspeed: " + rightWheel.getTargetSpeed());
        leftWheel.update();
        System.out.println("Left currentspeed: " + -leftWheel.getCurrentSpeed());
        System.out.println("Left targetspeed: " + -leftWheel.getTargetSpeed() +  "\n");
    }

    public void emergencyBrake() {
        neopixels.allRed();
        rightWheel.setSpeed(0);
        leftWheel.setSpeed(0);
    }

    public void right() {
        neopixels.rightWhite();
        rightWheel.setSpeed(20);
        leftWheel.setSpeed(0);
    }

    public void left() {
        neopixels.leftWhite();
        rightWheel.setSpeed(0);
        leftWheel.setSpeed(-20);
    }

    public void slowStop() {
        neopixels.allRed();
        rightWheel.setTargetSpeed(0);
        leftWheel.setTargetSpeed(0);
    }

    public boolean checkTargetSpeed() {
        return rightWheel.getTargetSpeed() == rightWheel.getCurrentSpeed() && leftWheel.getCurrentSpeed() == leftWheel.getTargetSpeed();
    }

    public void syncWheels() {
        if(rightWheel.getCurrentSpeed() > leftWheel.getCurrentSpeed()) {
            leftWheel.setSpeed(rightWheel.getCurrentSpeed());
        } else if(leftWheel.getCurrentSpeed() > rightWheel.getCurrentSpeed()) {
            rightWheel.setSpeed(leftWheel.getCurrentSpeed());
        }
    }

    public void turnLeft() {
        leftWheel.setSpeed(-20);
        rightWheel.setSpeed(0);
        BoeBot.wait(4200);
        emergencyBrake();
    }

    public void turnRight() {
        leftWheel.setSpeed(0);
        rightWheel.setSpeed(20);
        BoeBot.wait(4200);
        emergencyBrake();
    }

    @Override
    public void onTarget() {
        System.out.println("reached targetSpeed");
    }

}