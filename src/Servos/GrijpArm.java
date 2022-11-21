package Servos;
import TI.*;
import TI.BoeBot;
import TI.PinMode;
import TI.Servo;

public class GrijpArm {
    public static void main(String[] args) {
        Servo grijphaak = new Servo(13);
        grijphaak.start();

    }
}
