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


    public void setSpeedForward(int speed) {
        rightWheel.setTargetSpeed(speed);
        leftWheel.setTargetSpeed(-speed);
        update();
    }

    private void update() {
        rightWheel.update();
        leftWheel.update();
    }

    public void emergencyBrake() {
        rightWheel.setSpeed(0);
        leftWheel.setSpeed(0);
    }
}