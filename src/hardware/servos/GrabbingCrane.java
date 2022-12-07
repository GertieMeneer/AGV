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
        if (targetAngle != currentAngle) {
            while(currentAngle < targetAngle) {
                currentAngle++;
            }
            while(currentAngle > targetAngle) {
                currentAngle--;
            }
            servo.update(500 + currentAngle);
            BoeBot.wait(1);
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