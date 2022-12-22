package hardware;

public interface OverrideCallback {
    void driveForward();
    void driveBackward();
    void turnLeft();
    void turnRight();
    void OverrideOff();
    void OverrideOn();

}
