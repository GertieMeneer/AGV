package interfacing;

import TI.BoeBot;
import application.Menu.MenuActions.DebugActions.Fixer;
import application.Menu.MenuActions.DebugActions.UltraSoundDebug;
import hardware.sensors.Ultrasone;
import TI.*;
import sun.security.util.Debug;

import static TI.PinMode.Input;
import static TI.PinMode.Output;

public class CollisionController {
    private Ultrasone ultrasone;
    private Drive drive = new Drive();
    private int pulseTranslation;
    private Fixer debug;
    private UltraSoundDebug usd;

    public CollisionController() {
        this.ultrasone = new Ultrasone(11, 10);
        debug = new Fixer();
        usd = new UltraSoundDebug();
    }

    public void checkDistance() {
//        debug.turnOn();
        if (debug.debugMode()) {
            usd.debug();
        }

        this.pulseTranslation = ultrasone.checkDistance();
        if (pulseTranslation < 500) {
            drive.emergencyBrake();
        } else if (pulseTranslation < 1500) {
            drive.slowStop();
        } else {
            drive.driveForwardSlowSpeed();
        }


    }
}
