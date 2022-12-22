package hardwaretests;

import TI.BoeBot;
import TI.Timer;
import hardware.*;
import hardware.additional.Button;
import hardware.sensors.IR;
import hardware.sensors.Linesensor;
import hardware.sensors.Ultrasone;
import hardware.servos.GrabbingCrane;
import interfacing.CollisionController;
import interfacing.Drive;
import interfacing.NotificationsController;
import interfacing.OverrideController;

import javax.crypto.spec.DESedeKeySpec;
import java.awt.*;
import java.util.ArrayList;

public class TotalTest implements CollisionCallback, ButtonCallback, GripperCallback, WheelCallback, OverrideCallback, LineCallback {
    private NotificationsController nc;
    private Ultrasone ultrasone;
    private ArrayList<Updatable> devices;
    private Button stopButton;
    private Button resumeButton;
    private Drive drive;
    private GrabbingCrane grabbingCrane;
    private IR ir;
    private Linesensor leftsensor;
    private Linesensor rightsensor;
    private boolean override = false;

    public static void main(String[] args) {
        TotalTest main = new TotalTest();
        main.run();
    }

    private void run() {
        while (true) {
            if (!override) {
                for (Updatable devices : this.devices) {
                    devices.update();
                }
            } else {
                ir.update();
                resumeButton.update();
            }
            BoeBot.wait(1);
        }
    }

    public TotalTest() {
        CollisionController collisionController = new CollisionController(this);
        OverrideController overrideController = new OverrideController(this);

        nc = new NotificationsController();
        drive = new Drive();

        ir = new IR(2, overrideController);
        resumeButton = new Button(0, this);

        this.devices = new ArrayList<>();
        this.devices.add(leftsensor = new Linesensor(2, this));
        this.devices.add(rightsensor = new Linesensor(0, this));
        this.devices.add(grabbingCrane = new GrabbingCrane(14, this));
        this.devices.add(ultrasone = new Ultrasone(11, 10, collisionController));
        this.devices.add(stopButton = new Button(1, this));
    }

    @Override
    public void onAlmostCollision() {
        BoeBot.rgbSet(4, Color.YELLOW);
        BoeBot.rgbShow();
    }

    @Override
    public void onNearCollision() {
        BoeBot.rgbSet(4, Color.RED);
        BoeBot.rgbShow();
    }

    @Override
    public void isSafe() {
        BoeBot.rgbSet(4, Color.BLACK);
        BoeBot.rgbShow();
    }

    @Override
    public void buttonPressed(Button button) {
        if (stopButton == button) {
            BoeBot.rgbSet(1, Color.red);
            BoeBot.rgbShow();
            override = true;
//            grabbingCrane.open();
        }
        if (resumeButton == button) {
            nc.allOff();
            override = false;
//            grabbingCrane.close();
        }
    }

    @Override
    public void onTarget() {
        System.out.println("reached targetState");
    }

    @Override
    public void driveForward() {
        BoeBot.rgbSet(0, Color.orange);
        BoeBot.rgbShow();
    }

    @Override
    public void driveBackward() {
        BoeBot.rgbSet(0, Color.red);
        BoeBot.rgbShow();
    }

    @Override
    public void turnLeft() {
        BoeBot.rgbSet(0, Color.blue);
        BoeBot.rgbShow();
    }

    @Override
    public void turnRight() {
        BoeBot.rgbSet(0, Color.green);
        BoeBot.rgbShow();
    }

    @Override
    public void OverrideOff() {
        nc.allOff();
        override = false;
    }


    @Override
    public void onMeasure(Linesensor linesensor) {
        if (leftsensor == linesensor){
            BoeBot.rgbSet(3, Color.orange);
            BoeBot.rgbShow();
        }else{
            BoeBot.rgbSet(3, Color.BLACK);
            BoeBot.rgbSet(5, Color.BLACK);
            BoeBot.rgbShow();
        }

        if (rightsensor == linesensor){
            BoeBot.rgbSet(5, Color.orange);
            BoeBot.rgbShow();
        }else{
            BoeBot.rgbSet(3, Color.BLACK);
            BoeBot.rgbSet(5, Color.BLACK);
            BoeBot.rgbShow();
        }
    }
}

