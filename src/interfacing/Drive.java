package interfacing;

import hardware.Updatable;
import hardware.servos.Wheel;

public class Drive implements Updatable {
    private Wheel rightWheel;
    private Wheel leftWheel;
    private NotificationsController neopixels = new NotificationsController();
    private Crane crane = new Crane(14);

    public Drive() {
        rightWheel = new Wheel(12);
        leftWheel = new Wheel(13);
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

    public void open() {

    }

    public void close() {

    }
}