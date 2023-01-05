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
    private Timer timer;

    public Wheel(int pin, WheelCallback callback) {
        this.timer = new Timer(100);
        this.pin = pin;
        this.servo = new Servo(pin);
        this.currentSpeed = 0;
        this.targetSpeed = 0;
        this.callback = callback;
    }

    public void setTargetSpeed(int targetSpeed) {
        this.targetSpeed = targetSpeed;
        update();
    }

    public void setSpeed(int speed) {
        currentSpeed = speed;
        targetSpeed = 0;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getTargetSpeed() {
        return targetSpeed;
    }

    @Override
    public void update() {

        if (timer.timeout()) {
            if (targetSpeed != currentSpeed) {
                if (targetSpeed > currentSpeed) {
                    currentSpeed++;
                } else {
                    currentSpeed--;
                }
            }
            servo.update(1500 + currentSpeed);
            timer.mark();
        }
    }
}