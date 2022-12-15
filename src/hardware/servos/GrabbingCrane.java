package hardware.servos;

import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class GrabbingCrane {
    private final Servo servo;
    private int pin;
    private int currentAngle;
    private int targetAngle;

    public GrabbingCrane(int pin) {
        this.pin = pin;
        this.servo = new Servo(pin);
        this.currentAngle = 0;
        this.targetAngle = 0;
        BoeBot.setMode(this.pin, PinMode.Output);
    }

    public void update() {
        if (!(targetAngle == currentAngle)) {
            if (targetAngle > currentAngle) {
                currentAngle++;
            } else {
                currentAngle--;
            }

            if(currentAngle < -1000 || currentAngle > 1000) {
                currentAngle = 0;
            }

            servo.update(1500 + currentAngle);
        }

    }


    public void setTargetAngle(int targetAngle) {
        if (targetAngle <= 0 || targetAngle > 2300) {
            targetAngle = currentAngle;
        }
        this.targetAngle = targetAngle;
        update();
    }

    public int getCurrentAngle() {
        return currentAngle;
    }
}