import TI.BoeBot;
import TI.PinMode;
import TI.Servo;
import TI.Timer;
import hardware.additional.Button;
import hardware.sensors.Linesensor;
import hardware.sensors.Ultrasone;
import hardware.servos.GrabbingCrane;
import hardware.servos.Wheel;
import interfacing.*;

import java.nio.file.Path;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {
        new Demo1();
    }

    public Demo1() {
        PathTracker pt = new PathTracker();
        CollisionController collisionController = new CollisionController();
//        Drive drive = new Drive();
//
//        drive.turnRight();
//        BoeBot.wait(5000);

        while(true) {
            pt.checkLine();
            BoeBot.wait(50);
            collisionController.checkDistance();
            BoeBot.wait(50);

        }


    }
}