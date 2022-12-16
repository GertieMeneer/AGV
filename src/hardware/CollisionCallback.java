package hardware;

public interface CollisionCallback {
    void onAlmostCollision();
    void onNearCollision();
    void isSafe();
}
