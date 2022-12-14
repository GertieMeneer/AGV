package interfacing;

import hardware.sensors.Linesensor;

public class PathTracker {
    private int pin;
    private Linesensor linesensor;
    private String position;
    private Drive drive;

    public PathTracker() {

        drive = new Drive();
    }

    public void checkLine() {
        Linesensor leftsensor = new Linesensor(2, "left");
        Linesensor rightsensor = new Linesensor(0, "right");
        if ((leftsensor.checkLine() || rightsensor.checkLine())) {
            if (leftsensor.checkLine() && rightsensor.checkLine()) {
//                drive.setSpeedForward();
            } else if (rightsensor.checkLine()) {
//                drive.turnRight();
            } else if (leftsensor.checkLine()) {
//                drive.turnLeft();
            }
        } else {
//            drive.setSpeedForward();
        }
    }
}