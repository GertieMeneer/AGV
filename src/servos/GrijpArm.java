package servos;
import TI.Servo;

public class GrijpArm {


    public static void main(String[] args) {

            Servo grijphaak = new Servo(14);
            grijphaak.update(2300); // 12 rechterwiel boven 1500 achteruit. andere precies omgekeerd, grijparm 1700 dicht, 2300 open


    }
}

