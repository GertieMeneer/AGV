package hardware.servos;

import TI.*;

public class Wheel {
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

    public void update() {
        if(targetSpeed != currentSpeed) {
            if (currentSpeed < targetSpeed) {
                currentSpeed++;
            }

            if (currentSpeed > targetSpeed) {
                currentSpeed--;
            }
            servo.update(1500 + currentSpeed);
        }

    }

    public void setTargetSpeed(int targetSpeed) {
        this.targetSpeed = targetSpeed;
    }


}
