package interfacing;

import TI.BoeBot;
import TI.Servo;
import hardware.servos.GrabbingCrane;
import hardware.servos.Wheel;

public class Drive {
    private Wheel rightWheel;
    private Wheel leftWheel;
    private GrabbingCrane crane;
    private boolean isClosed = false;

    public Drive() {
        rightWheel = new Wheel(12);
        leftWheel = new Wheel(13);
        crane = new GrabbingCrane(14);
    }

    public void driveForwardFullSpeed() {
        rightWheel.setTargetSpeed(500);
        leftWheel.setTargetSpeed(-500);
        update();
    }

    public void driveForwardSlowSpeed() {
        rightWheel.setTargetSpeed(20);
        leftWheel.setTargetSpeed(-20);
        update();
    }

    public void driveBackwardSlowSpeed() {
        rightWheel.setTargetSpeed(-40);
        leftWheel.setTargetSpeed(40);
        update();
    }

    public void slowStop() {
        rightWheel.setTargetSpeed(0);
        leftWheel.setTargetSpeed(0);
        update();
    }


    public void emergencyBrake() {
        rightWheel.emergencyBrake();
        leftWheel.emergencyBrake();
        update();
    }

    public void update() {
        leftWheel.update();
        rightWheel.update();
        crane.update();
    }

    public void close() {
        crane.setTargetAngle(0);
        if(crane.getCurrentAngle() == 0) {
            isClosed = true;
        }
        crane.update();
    }

    public void open() {
        crane.setTargetAngle(1675);
        if(crane.getCurrentAngle() == 1675) {
            isClosed = false;
        }
        crane.update();
    }

    public void turnDegrees(int degree, int turnSpeed) {

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

    public boolean isClosed() {
        return isClosed;
    }

    public void turnLeft() {
        leftWheel.emergencyBrake();
        rightWheel.slow();
        update();
//        BoeBot.wait(5);
//        driveForwardSlowSpeed();
    }

    public void turnRight() {
        rightWheel.emergencyBrake();
        leftWheel.slow();
        update();
//        BoeBot.wait(5);
//        driveForwardSlowSpeed();
    }

    public void setSpeedForward() {
        rightWheel.setSpeed(1550);
        leftWheel.setSpeed(1450);
    }
}