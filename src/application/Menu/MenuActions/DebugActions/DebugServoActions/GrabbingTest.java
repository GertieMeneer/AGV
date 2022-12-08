package application.Menu.MenuActions.DebugActions.DebugServoActions;

import TI.Timer;
import application.Menu.MenuAction;
import interfacing.Drive;

public class GrabbingTest implements MenuAction {
    @Override
    public String getName() {
        return "Test de Grijarm";
    }

    @Override
    public void action() {
        Drive drive = new Drive();
        Timer t1 = new Timer(5000);
        t1.mark();
        while (true) {

//            if (drive.isClosed()) {
//                drive.open();
//            } else {
//                drive.close();
//            }
//
//            if (t1.timeout()) {
//                break;
            }
        }
    }

