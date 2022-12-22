package interfacing;

import hardware.CollisionCallback;
import hardware.SensorCallback;

public class CollisionController implements SensorCallback {

    private CollisionCallback callback;

    public CollisionController(CollisionCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onMeasure(int value) {
        if ( value >= 500 && value < 1000){
            callback.onAlmostCollision();
        }else if (value >= 0 && value < 500){
            callback.onNearCollision();
        }else{
            callback.isSafe();
        }
    }
}
