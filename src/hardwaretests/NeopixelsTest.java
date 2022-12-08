package hardwaretests;

import TI.BoeBot;

import java.awt.*;

public class NeopixelsTest {

    public static void main(String[] args) {
        new NeopixelsTest();
    }

    private NeopixelsTest() {
        allOn();
        BoeBot.wait(1000);
        allOff();
        BoeBot.wait(1000);
    }

    private void allOn() {
        for (int i = 0; i < 6; i++) {
            BoeBot.rgbSet(i, Color.white);
            BoeBot.rgbShow();
            BoeBot.wait(1000);
        }
    }

    private void allOff() {
        for (int i = 0; i < 6; i++) {
            BoeBot.rgbSet(i, Color.black);
            BoeBot.rgbShow();
            BoeBot.wait(1000);
        }
    }
}
