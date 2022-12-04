package application.Menu.MenuActions;

import application.Menu.MenuAction;
import hardware.sensors.Ultrasone;
import interfacing.CollisionController;
import interfacing.Drive;

public class Debug implements MenuAction {

    @Override
    public String getName() {
        return "Drive and stop";
    }

    @Override
    public void action() {
        Drive drive = new Drive();
        CollisionController collisionController = new CollisionController();

        if(collisionController.checkNormalStop()) {
            drive.slowStop();
        } else if (collisionController.checkEmergencyStop()){
            drive.emergencyBrake();
        } else {
            drive.driveForwardSlowSpeed();
        }

    }
}
