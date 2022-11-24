package Hardware.servos;
import TI.BoeBot;
import TI.Servo;

public class GrabingCrane {

    public static void open() {
        Servo grijphaak = new Servo(14);
        grijphaak.update(2300);
    }

    public static void close() {
        Servo grijphaak = new Servo(14);
        grijphaak.update(1675);
    }

    public static void slowlyOpen() {
        Servo grijphaak = new Servo(14);
        for (int i = 1700; i < 2300; i++) {
            grijphaak.update(i);
            BoeBot.wait(1);
        }
    }

    public static void slowlyClose() {
        Servo grijphaak = new Servo(14);
        for (int i = 2300; i > 1675; i--) {
            grijphaak.update(i);
            BoeBot.wait(1);
        }
    }
//    public void testMethod() {
//
//        grijphaak.update(2300); // 12 rechterwiel boven 1500 achteruit. andere precies omgekeerd, grijparm 1700 dicht, 2300 open
//    }
}

