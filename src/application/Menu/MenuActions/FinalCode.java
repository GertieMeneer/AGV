package application.Menu.MenuActions;

import application.Menu.MenuAction;
import interfacing.*;

public class FinalCode implements MenuAction {
    @Override
    public String getName() {
        return "Final Program";
    }

    @Override
    public void action() {
        FinalCode();
    }

    public void FinalCode() {
        Drive drive =  new Drive();
        NotificationsController notificationsController =  new NotificationsController();
        CollisionController collisionController = new CollisionController();
        OverrideController overrideController = new OverrideController();
//        PathTracker pathTracker = new PathTracker();

//Hier komt de uiteindelijke code
    }
}
