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
        rightWheel.setTargetSpeed(40);
        leftWheel.setTargetSpeed(-40);
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
        isClosed = true;
        crane.update();
    }

    public void open() {
        crane.setTargetAngle(1675);
        isClosed = false;
        crane.update();
    }

    public void turnDegrees(int degree, int turnSpeed) {
        Servo rightWheel = new Servo(13);
        Servo leftWheel = new Servo(12);

        if (turnSpeed < 0) {
            leftWheel.update(1494 + turnSpeed);
            rightWheel.update(1500 + turnSpeed);
        } else {
            rightWheel.update(1500 - turnSpeed);
            leftWheel.update(1494 - turnSpeed);
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
}
