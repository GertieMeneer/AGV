package application.Menu.MenuActions.DebugActions;

import TI.BoeBot;
import hardware.sensors.Ultrasone;
import interfacing.NotificationsController;

import java.awt.*;

public class UltraSoundDebug {
    private Ultrasone us;

    public UltraSoundDebug() {
        this.us = new Ultrasone(11,10);
    }


    public void debug() {
        NotificationsController nc = new NotificationsController();
        int pulseTranslation = us.checkDistance();
            if (pulseTranslation < 1000){
                nc.allRed();
            }else if (pulseTranslation > 1000 && pulseTranslation < 2500){
                nc.allBlue();
            }else{
                nc.allOff();
            }
            BoeBot.wait(50);
    }

    public static void main(String[] args) {
        UltraSoundDebug usd = new UltraSoundDebug();
        while (true){
            usd.debug();
        }

    }
}