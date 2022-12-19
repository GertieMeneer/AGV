package hardware.servos;

import TI.*;
import hardware.Updatable;
import hardware.WheelCallback;

public class Wheel implements Updatable {
    private final int pin;
    private final Servo servo;
    private int currentSpeed;
    private int targetSpeed;
    private WheelCallback callback;

    public Wheel(int pin, WheelCallback callback) {
        this.pin = pin;
        this.servo = new Servo(pin);
        this.currentSpeed = 1500;
        this.targetSpeed = 1500;
        this.callback = callback;
    }

    public void setTargetSpeed(int targetSpeed) {
        this.targetSpeed = targetSpeed;
        update();
    }

    public void setSpeed(int speed) {
        servo.update(1500 + speed);
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getTargetSpeed() {
        return targetSpeed;
    }

    @Override
    public void update() {
        if (targetSpeed != currentSpeed) {
            if (targetSpeed > currentSpeed) {
                currentSpeed++;
            } else {
                currentSpeed--;
            }
            servo.update(currentSpeed);
            if (currentSpeed == targetSpeed) {
                callback.onTarget();
            }
        }
    }
}