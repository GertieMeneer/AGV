package interfacing;

import hardware.CollisionCallback;
import hardware.UltrasonCallback;

public class CollisionController implements UltrasonCallback {

    private CollisionCallback callback;

    public CollisionController(CollisionCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onMeasure(int time) {
        if ( time >= 500 && time < 1000){
            callback.onAlmostCollision();
        }else if (time >= 0 && time < 500){
            callback.onNearCollision();
        }else{
            callback.isSafe();
        }
    }
}
