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

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {
        new Demo1();
    }

    public Demo1() {
        PathTracker pt = new PathTracker();
        CollisionController collisionController = new CollisionController();
        IR remote = new IR(2);
        Drive drive = new Drive();
        Bluetooth bluetooth = new Bluetooth();
        Servo wheel = new Servo(12);

        Wheel wheel2 = new Wheel (12);

        drive.setSpeedForward();
        BoeBot.wait(1000);


        while (true) {
            drive.slowStop();
//            drive.driveForwardSlowSpeed();

//            remote.readIRLes();
//            BoeBot.wait(10);
//            pt.checkLine();
//            BoeBot.wait(50);
//            collisionController.checkDistance();
//            BoeBot.wait(100);
//            bluetooth.readBluetoothModule();
//            BoeBot.wait(50);
//            drive.driveForwardFullSpeed();
//            drive.driveForwardSlowSpeed();
//            drive.driveForwardFullSpeed();
//            BoeBot.wait(1000);
//            drive.slowStop();
//            BoeBot.wait(1000);
//            drive.driveForwardFullSpeed();
            BoeBot.wait(10);
        }


    }

}