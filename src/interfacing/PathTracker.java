package interfacing;

import hardware.PathTrackerCallback;
import hardware.SensorCallback;
import hardware.sensors.Linesensor;

public class PathTracker implements SensorCallback {

    private PathTrackerCallback callback;

    public PathTracker(PathTrackerCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onMeasure(int value) {
        if (value > 900){
          callback.seeLine();
        }
    }
}