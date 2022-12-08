package interfacing;

import TI.BoeBot;
import TI.Servo;
import hardware.servos.GrabbingCrane;
import hardware.servos.Wheel;

public class Drive {
    private Wheel rightWheel;
    private Wheel leftWheel;
    private NotificationsController neopixels = new NotificationsController();

    public Drive() {
        rightWheel = new Wheel(12);
        leftWheel = new Wheel(13);
    }

    public void driveForwardFullSpeed() {
        rightWheel.setTargetSpeed(500);
        leftWheel.setTargetSpeed(-500);
        update();
        neopixels.allOff();
        neopixels.forwardWhite();

    }

    public void driveForwardSlowSpeed() {
        rightWheel.setTargetSpeed(20);
        leftWheel.setTargetSpeed(-20);
        update();
        neopixels.allOff();
        neopixels.forwardWhite();
    }

    public void driveBackwardSlowSpeed() {
        rightWheel.setTargetSpeed(-40);
        leftWheel.setTargetSpeed(40);
        update();
        neopixels.allOff();
        neopixels.backwardsWhite();
    }

    public void slowStop() {
        rightWheel.setTargetSpeed(0);
        leftWheel.setTargetSpeed(0);
        update();
//        neopixels.
    }


    public void emergencyBrake() {
        rightWheel.emergencyBrake();
        leftWheel.emergencyBrake();
        update();
        neopixels.allOff();
        neopixels.allRed();
    }

    public void update() {
        leftWheel.update();
        rightWheel.update();
    }

//    public void close() {
//        crane.setTargetAngle(0);
//        if(crane.getCurrentAngle() == 0) {
//            isClosed = true;
//        }
//        crane.update();
//    }

//    public void open() {
//        crane.setTargetAngle(1675);
//        if(crane.getCurrentAngle() == 1675) {
//            isClosed = false;
//        }
//        crane.update();
//    }

    public void turnDegrees(int degree) {
        int turnSpeed = 500;

        if (turnSpeed < 0) {
            leftWheel.setSpeed(turnSpeed);
            rightWheel.setSpeed(turnSpeed);
        } else {
            rightWheel.setSpeed(turnSpeed);
            leftWheel.setSpeed(turnSpeed);
        }

        if (degree == 90){
            BoeBot.wait(2500);
        }
        if (degree == 180){
            BoeBot.wait(5000);
        }
        emergencyBrake();
    }

//    public boolean isClosed() {
//        return isClosed;
//    }

    public void turnLeft() {
        leftWheel.emergencyBrake();
        rightWheel.slow();
        update();
        neopixels.leftWhite();
//        BoeBot.wait(5);
//        driveForwardSlowSpeed();
    }

    public void turnRight() {
        rightWheel.emergencyBrake();
        leftWheel.slow();
        update();
        neopixels.rightWhite();
//        BoeBot.wait(5);
//        driveForwardSlowSpeed();
    }

    public void setSpeedForward() {
        rightWheel.setSpeed(1550);
        leftWheel.setSpeed(1450);
        neopixels.allOff();
        neopixels.forwardWhite();

    }
}