package application.Menu.MenuActions.DebugActions.DebugServoActions;

import TI.Timer;
import application.Menu.MenuAction;
import hardware.servos.GrabbingCrane;
import interfacing.Drive;

public class DriveTest implements MenuAction {

    @Override
    public String getName() {
        return "Test de motoren";
    }

    @Override
    public void action() {
        Drive drive = new Drive();
        GrabbingCrane grabbingCrane = new GrabbingCrane(0);
        Timer t1 = new Timer(10000);
        Timer t2 = new Timer(10000);
        Timer t3 = new Timer(10000);
        Timer t4 = new Timer(10000);
        Timer t5 = new Timer(3000);

        t4.mark();

        while (true) {
            if (t4.timeout()) {
//                drive.driveForwardSlowSpeed();
                t1.mark();
            }

            if (t1.timeout()) {
//                drive.slowStop();
                t2.mark();
            }

            if (t2.timeout()) {
//                drive.driveForwardFullSpeed();
                t3.mark();
            }

            if (t3.timeout()) {
                drive.emergencyBrake();
                t5.mark();
            }

            if (t5.timeout()) {
                break;
            }
        }
    }
}
