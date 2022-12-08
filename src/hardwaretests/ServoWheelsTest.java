package hardwaretests;

import TI.BoeBot;
import TI.Servo;

public class ServoWheelsTest {
    Servo s1 = new Servo(12);
    Servo s2 = new Servo(13);
    public static void main(String[] args) {
        new ServoWheelsTest();
    }

    private ServoWheelsTest() {
        drive();
        BoeBot.wait(1000);
        stop();
        BoeBot.wait(1000);
    }

    private void drive() {
        s1.update(2500);
        s2.update(500);
    }

    private void stop() {
        s1.update(1500);
        s2.update(1500);
    }
}
