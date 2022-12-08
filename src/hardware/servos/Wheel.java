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
        }
        servo.update(1500 + currentSpeed);

    }

    public void emergencyBrake(){
        this.currentSpeed = 0;
        this.targetSpeed = 0;
        update();
    }

    public void slow() {
        if(this.pin == 12) {
            this.targetSpeed = 25;
        } else {
            this.targetSpeed = -25;
        }
        update();
    }


    public void setSpeed(int speed) {
        servo.update(speed);
        if (this.pin == 13) {
            this.currentSpeed = -50;
        } else {
            this.currentSpeed = 50;
        }
    }

    public void setTargetSpeed(int targetSpeed) {
        this.targetSpeed = targetSpeed;
    }


}
