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
    private PathTracker pt = new PathTracker();
    private CollisionController collisionController = new CollisionController();
    private IR remote = new IR(2);
    private Drive drive = new Drive();
    private Bluetooth bluetooth = new Bluetooth();
    private Crane crane = new Crane(14);

    public static void main(String[] args) {
        new Demo1();
    }

    public Demo1() {
        while (true) {
            pt.checkLine();

//            crane.open();
//            BoeBot.wait(3000);
            crane.close();
//            BoeBot.wait(3000);

//            collisionController.checkDistance();

//            bluetooth.readBluetoothModule();
//            BoeBot.wait(1);

        }
    }
}