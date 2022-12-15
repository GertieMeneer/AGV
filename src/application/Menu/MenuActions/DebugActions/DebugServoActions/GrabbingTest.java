package application.Menu.MenuActions.DebugActions.DebugServoActions;

import TI.Timer;
import application.Menu.MenuAction;
import interfacing.Crane;
import interfacing.Drive;

public class GrabbingTest implements MenuAction {
    @Override
    public String getName() {
        return "Test de Grijarm";
    }

    @Override
    public void action() {
        Crane crane = new Crane(14);
        Timer t1 = new Timer(5000);
        t1.mark();
        while (true) {

            if (crane.getStatus()) {
                crane.open();
            } else {
                crane.close();
            }
            if (t1.timeout()) {
                break;
            }
        }
    }
}

