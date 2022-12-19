package hardwaretests;

import TI.BoeBot;
import TI.Servo;
import TI.Timer;
import hardware.servos.Wheel;
import interfacing.CollisionController;
import interfacing.Drive;

public class ServoWheelsTest {
    private Drive drive;

    public static void main(String[] args) {
        new ServoWheelsTest();
    }


    private ServoWheelsTest() {
        Drive drive = new Drive();
        boolean check = false;
        Timer t1 = new Timer(3000);
        Timer t2 = new Timer(3000);
//        CollisionController collisionController = new CollisionController();

        while (true) {
            BoeBot.wait(50);
            if (drive.checkTargetSpeed() && check) {
                drive.emergencyBrake();
                check = false;
                System.out.println("somehow works first try");
                drive.setTargetSpeed(100);
            } else {
                drive.setTargetSpeed(100);
                System.out.println("move");
                check = true;
            }
            drive.update();
        }
    }
}