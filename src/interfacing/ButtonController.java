package interfacing;

public class ButtonController {

    public void emergencyStop() {
        Drive drive = new Drive();
        drive.emergencyBrake();
        drive.open();
    }
}
