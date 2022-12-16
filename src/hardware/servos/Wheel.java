package hardware.servos;

import TI.*;
import hardware.Updatable;

public class Wheel implements Updatable {
    private final int pin;
    private final Servo servo;
    private int currentSpeed;
    private int targetSpeed;

    public Wheel(int pin) {
        this.pin = pin;
        this.servo = new Servo(pin);
        this.currentSpeed = 0;
        this.targetSpeed = 0;
    }

    public void driveforwardslowaccelerating() {
        this.targetSpeed = 500;
        update();
    }

    public void driveforwardfastaccelerting() {
        this.targetSpeed = 1000;
    }


    public void setTargetSpeed(int targetSpeed) {
        this.targetSpeed = targetSpeed;
    }

    public void setSpeed(int speed) {
        currentSpeed = speed;
        update();
    }

    @Override
    public void update() {
        if (!(targetSpeed == currentSpeed)) {
            if (targetSpeed > currentSpeed) {
                currentSpeed++;
            } else {
                currentSpeed--;
            }

            if(currentSpeed < -1000 || currentSpeed > 1000) {
                currentSpeed = 0;
            }

            servo.update(1500 + currentSpeed);
        }
    }
}