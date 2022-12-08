import TI.BoeBot;
import TI.PinMode;
import TI.Servo;
import TI.Timer;
import hardware.additional.Bluetooth;
import hardware.additional.Button;
import hardware.sensors.IR;
import hardware.sensors.Linesensor;
import hardware.sensors.Ultrasone;
import hardware.servos.GrabbingCrane;
import hardware.servos.Wheel;
import interfacing.*;

import java.awt.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    private NotificationsController controller = new NotificationsController();
    private Drive drive = new Drive();

    public static void main(String[] args) {
        new Demo1();
    }

    public Demo1() {
//        PathTracker pt = new PathTracker();
//            CollisionController collisionController = new CollisionController();
//        IR remote = new IR(2);
//        Drive drive = new Drive();
//        Bluetooth bluetooth = new Bluetooth();
//        drive.setSpeedForward();
//        BoeBot.wait(1000);
//
//
//        while (true) {
//            drive.driveForwardSlowSpeed();
//            remote.readIRLes();
////            BoeBot.wait(1);
//            pt.checkLine();
//            BoeBot.wait(50);
//            collisionController.checkDistance();
////            BoeBot.wait(1);
//            bluetooth.readBluetoothModule();
////            BoeBot.wait(1);
//        }
//

    }


}