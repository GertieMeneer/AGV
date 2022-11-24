package interfacing;

import hardware.additional.NeoPixels;
import hardware.servos.GrabbingCrane;
import hardware.servos.Wheel;

public class Drive {
    private Wheel rightWheel;
    private Wheel leftWheel;
    private GrabbingCrane crane;

    public Drive() {
        rightWheel = new Wheel(12);
        leftWheel = new Wheel(13);
        crane = new GrabbingCrane(14);
    }

    public void driveForwardFullSpeed() {
        rightWheel.setTargetSpeed(500);
        leftWheel.setTargetSpeed(-500);
        NeoPixels.forwardWhite();
    }

    public void driveForwardSlowSpeed() {
        rightWheel.setTargetSpeed(40);
        leftWheel.setTargetSpeed(-40);
        NeoPixels.forwardWhite();
    }

    public void emergencyBrake() {
        rightWheel.setTargetSpeed(0);
        leftWheel.setTargetSpeed(0);
        NeoPixels.allRed();
    }

    public void update() {
        leftWheel.update();
        rightWheel.update();
        crane.update();
    }
}
