package interfacing;

public class OverrideController {

    public OverrideController() {
    }

    public void emergencyStop() {
        Drive drive = new Drive();
        drive.emergencyBrake();
        drive.open();
    }
}
