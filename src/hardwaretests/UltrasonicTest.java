package hardwaretests;

import TI.BoeBot;
import hardware.CollisionCallback;
import hardware.sensors.Ultrasone;
import interfacing.CollisionController;
import interfacing.NotificationsController;

public class UltrasonicTest implements CollisionCallback {
    private Ultrasone ultrasone;
    private NotificationsController nc;

    public static void main(String[] args) {
        UltrasonicTest main = new UltrasonicTest();
        main.run();
    }

    private UltrasonicTest() {

        CollisionController collisionController = new CollisionController(this);
        nc = new NotificationsController();
        ultrasone = new Ultrasone(11,10, collisionController);
    }

    private void run(){
        while(true){
            ultrasone.update();  // there are going to be more devices in the application. So an ArrayList needs to be made then.
            BoeBot.rgbShow();
            BoeBot.wait(1);
        }
    }

    @Override
    public void onAlmostCollision() {
        nc.allBlue();
    }

    @Override
    public void onNearCollision() {
        nc.allRed();
    }

    @Override
    public void isSafe() {
        nc.allOff();
    }
}
