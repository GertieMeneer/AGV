package hardwaretests;

import TI.BoeBot;
import TI.PinMode;
import TI.Timer;
import hardware.OverrideCallback;
import hardware.sensors.IR;
import interfacing.NotificationsController;
import interfacing.OverrideController;

public class IRTest implements OverrideCallback {
    private IR ir;
    private NotificationsController nc;
    private OverrideController overrideController;

    public static void main(String[] args) {
        IRTest ir = new IRTest();
        ir.run();
    }

    private IRTest() {
        nc = new NotificationsController();
        overrideController = new OverrideController(this);
        ir = new IR(2, overrideController);
    }

    private void run() {
        while(true){
            ir.update();
            BoeBot.wait(1);
        }
    }

    @Override
    public void driveForward() {
        nc.forwardWhite();
    }

    @Override
    public void driveBackward() {
        nc.backwardsWhite();
    }

    @Override
    public void turnLeft() {
        nc.leftWhite();
    }

    @Override
    public void turnRight() {
        nc.rightWhite();
    }

    @Override
    public void OverrideOff() {
        nc.allOff();
    }

    @Override
    public void OverrideOn() {

    }

    @Override
    public void brake() {

    }

    @Override
    public void gripperOpen() {

    }

    @Override
    public void gripperClose() {

    }

}
