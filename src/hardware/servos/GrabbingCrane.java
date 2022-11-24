package hardware.servos;
import TI.BoeBot;
import TI.Servo;

public class GrabbingCrane {
    private final Servo servo;
    private int pin;

    public GrabbingCrane(int pin) {
        this.pin = pin;
        this.servo= new Servo(pin);
    }

    public void open() {
        servo.update(2300);
    }

    public  void close() {
        servo.update(1675);
    }

    public void slowlyOpen() {
        for (int i = 1700; i < 2300; i++) {
            servo.update(i);
            BoeBot.wait(1);
        }
    }

    public void slowlyClose() {
        for (int i = 2300; i > 1675; i--) {
            servo.update(i);
            BoeBot.wait(1);
        }
    }
//    public void testMethod() {
//
//        grijphaak.update(2300); // 12 rechterwiel boven 1500 achteruit. andere precies omgekeerd, grijparm 1700 dicht, 2300 open
//    }
}

