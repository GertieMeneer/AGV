package servos;
import TI.Servo;

public class GrabingCrane {

    private int pin;

    public GrabingCrane(int pin) {
        this.pin = pin;
    }

    public void close() {

    }

    public void open() {

    }

//do we also need a move method? f.e move up, move down etc.

    public void testMethod() {
        Servo grijphaak = new Servo(14);
        grijphaak.update(2300); // 12 rechterwiel boven 1500 achteruit. andere precies omgekeerd, grijparm 1700 dicht, 2300 open
    }
}

