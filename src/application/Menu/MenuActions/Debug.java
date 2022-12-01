package application.Menu.MenuActions;

import application.Menu.MenuAction;
import hardware.sensors.Ultrasone;
import interfacing.Drive;

public class Debug implements MenuAction {

    @Override
    public String getName() {
        return "Drive and stop";
    }

    @Override
    public void action() {
        Drive drive = new Drive();
        Ultrasone ultrasoneClose = new Ultrasone(3, 4, 1000);
        Ultrasone ultrasoneFar = new Ultrasone(3, 4, 500);

        if(ultrasoneClose.checkDistance()) {
            drive.slowStop();
        } else if (ultrasoneFar.checkDistance()){
            drive.emergencyBrake();
        } else {
            drive.driveForwardSlowSpeed();
        }

    }
}
