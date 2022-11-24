import TI.BoeBot;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        BoeBot.rgbSet(1, Color.red);
        for (int i = 0; i < 6; i++) {
            BoeBot.rgbSet(i, Color.red);
        }
        BoeBot.rgbShow();
    }


}