package application.Menu.MenuActions.DebugActions;

import TI.Timer;
import application.Menu.MenuAction;
import hardware.servos.GrabbingCrane;
import hardware.servos.Wheel;
import interfacing.Drive;

public class ServoActions implements MenuAction {
    private Drive drive = new Drive();
    private GrabbingCrane grabbingCrane = new GrabbingCrane(0);
    private Timer t1 = new Timer(10000);
    private Timer t2 = new Timer(10000);
    private Timer t3 = new Timer(10000);
    private Timer t4 = new Timer(10000);

    public void testDrive() {

        while (true) {

            while (true) {

                drive.driveForwardSlowSpeed();
                t1.mark();

                if (t1.timeout()) {
                    drive.slowStop();
                    t2.mark();
                }

                if (t2.timeout()) {
                    drive.driveForwardFullSpeed();
                    t3.mark();
                }

                if (t3.timeout()) {
                    drive.emergencyBrake();
                }
            }
        }
    }

    public void testGrabbing() {

    }

    @Override
    public String getName() {
        return "Test Servo's";
    }

    @Override
    public void action() {

    }
}
