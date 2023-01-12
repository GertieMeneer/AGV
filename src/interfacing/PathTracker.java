package interfacing;

import hardware.LineCallback;
import hardware.PathTrackerCallback;
import hardware.SensorCallback;
import hardware.Updatable;
import hardware.sensors.Linesensor;

import javax.sound.sampled.Line;

public class PathTracker implements LineCallback, Updatable {

    private PathTrackerCallback callback;
    private Linesensor leftSensor;
    private Linesensor rightSensor;
    private Drive driving;
    private boolean LineSensorChanged = false;

    public PathTracker(Drive drive, PathTrackerCallback callback) {
        this.callback = callback;
        leftSensor = new Linesensor(2, this);
        rightSensor = new Linesensor(0, this);
        driving = drive;
    }

    @Override
    public void onMeasure() {
        int rightValue = rightSensor.update();
        System.out.println(rightValue);
        int leftValue = leftSensor.update();
        System.out.println(leftValue);

        System.out.println("LeftSensor: " + leftValue);
        System.out.println("RightSensor: " + rightValue);

        if (rightValue > 900 || leftValue > 900) {
            if (rightValue > 900 && leftValue <= 900) {
                driving.right();
                LineSensorChanged = true;
            }

            if (leftValue > 900 && rightValue <= 900) {
                driving.left();
                LineSensorChanged = true;
            }

            if (leftValue > 900 && rightValue > 900) {
                //shit met de navigate
                driving.setSpeed(20);
                LineSensorChanged = true;
            }
        } else {
            LineSensorChanged = false;
            driving.setSpeed(20);
        }
    }

    public boolean isLineSensorChanged() {
        return LineSensorChanged;
    }

    @Override
    public void update() {
        onMeasure();
    }
}