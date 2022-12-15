package hardwaretests;

import TI.BoeBot;
import TI.Servo;

public class GrabbingCraneTest {
    private Servo crane = new Servo(14);

    public static void main(String[] args) {
        new GrabbingCraneTest();
    }

    private GrabbingCraneTest() {
        open();
        BoeBot.wait(1000);
        close();
        BoeBot.wait(1000);
    }

    private void open() {
        crane.update(1750);
    }

    private void close() {
        crane.update(500);
    }
}
