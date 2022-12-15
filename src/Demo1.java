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

    public static void main(String[] args) {
        new Demo1();
    }

    public Demo1() {
        Bluetooth bluetooth = new Bluetooth();

        while(true) {
            bluetooth.readBluetoothModule();
            BoeBot.wait(10);
        }
    }
}