package interfacing;

import hardware.LineCallback;
import hardware.PathTrackerCallback;
import hardware.SensorCallback;
import hardware.sensors.Linesensor;

public class PathTracker {

    private PathTrackerCallback callback;

    public PathTracker(PathTrackerCallback callback) {
        this.callback = callback;
    }
}