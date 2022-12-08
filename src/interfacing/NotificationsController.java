package interfacing;

import TI.BoeBot;

import java.awt.*;
import java.util.ArrayList;

public class NotificationsController {

    public NotificationsController() {
    }

    public void allRed() {
        for (int i = 0; i < 6; i++) {
            BoeBot.rgbSet(i, Color.red);
        }
        BoeBot.rgbShow();
    }

    public void allOff() {
        for (int i = 0; i < 6; i++) {
            BoeBot.rgbSet(i, Color.black);
        }
        BoeBot.rgbShow();
    }

    public void forwardWhite() {
        for (int i = 3; i < 6; i++) {
            BoeBot.rgbSet(i, Color.white);
        }
        BoeBot.rgbShow();
    }

    public void backwardsWhite() {
        BoeBot.rgbSet(0
                , Color.white);
        BoeBot.rgbSet(1, Color.white);
        BoeBot.rgbSet(2, Color.white);
        BoeBot.rgbShow();
    }

    public void leftWhite() {
        BoeBot.rgbSet(3, Color.white);
        BoeBot.rgbSet(2, Color.white);
        BoeBot.rgbShow();
    }

    public void rightWhite() {
        BoeBot.rgbSet(5, Color.white);
        BoeBot.rgbSet(0, Color.white);
        BoeBot.rgbShow();
    }

    public void allBlue() {
        for (int i = 0; i < 6; i++) {
            BoeBot.rgbSet(i, Color.blue);
        }
        BoeBot.rgbShow();
    }

}
