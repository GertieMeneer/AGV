package application.Menu.MenuActions;

import hardware.additional.LED;
import interfacing.Drive;
import interfacing.NotificationsController;

public class MenuStop {
    Drive drive = new Drive();
    NotificationsController notificationsController = new NotificationsController();


    public void Stop() {
        drive.emergencyBrake();
        notificationsController.allBlack();
    }
}
