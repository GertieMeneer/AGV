package Hardware.servos;

import TI.*;

public class Wheel {
    private int GPIOpin;
    private Servo wheel = new Servo(this.GPIOpin);

    public Wheel(int GPIOpin) {
        this.GPIOpin = GPIOpin;
    }

    public void driveForwardFullSpeed() {
        if(this.GPIOpin == 12) {
            this.wheel.update(2500);
        } else {
            this.wheel.update(500);
        }
    }

    public void driveForwardSlowSpeed() {
        if(this.GPIOpin == 12) {
            this.wheel.update(2000);
        } else {
            this.wheel.update(1000);
        }
    }

    public void emergencyBrake() {
        this.wheel.update(1500);
    }
}
