package interfacing;

import TI.BoeBot;
import TI.Servo;
import hardware.servos.GrabbingCrane;
import hardware.servos.Wheel;

public class Drive {
    private Wheel rightWheel;
    private Wheel leftWheel;
    private NotificationsController neopixels = new NotificationsController();
    private Crane crane = new Crane(14);

    public Drive() {
        rightWheel = new Wheel(12);
        leftWheel = new Wheel(13);
    }

    public void driveForwardFullSpeed() {
        rightWheel.setTargetSpeed(500);
        leftWheel.setTargetSpeed(-500);
        update();
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
        neopixels.backwardsWhite();
    }

    public void slowStop() {
        rightWheel.setTargetSpeed(0);
        leftWheel.setTargetSpeed(0);
        update();
        neopixels.allOff();
    }


    public void emergencyBrake() {
        rightWheel.emergencyBrake();
        leftWheel.emergencyBrake();
        update();
        neopixels.allRed();
    }

    public void update() {
        leftWheel.update();
        rightWheel.update();
    }

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
        neopixels.forwardWhite();
    }

    public void setSpeedBackward() {
        rightWheel.setSpeed(1450);
        leftWheel.setSpeed(1550);
        neopixels.backwardsWhite();
    }

    public void getCart() {
        neopixels.allWhite();
        turnDegrees(90);
        crane.open();
        driveBackwardSlowSpeed();
        BoeBot.wait(1000);
        emergencyBrake();
        crane.close();
    }
}