package hardwaretests;

import TI.BoeBot;
import TI.Timer;
import hardware.ButtonCallback;
import hardware.CollisionCallback;
import hardware.Updatable;
import hardware.additional.Button;
import hardware.sensors.Linesensor;
import hardware.sensors.Ultrasone;
import interfacing.CollisionController;
import interfacing.Drive;
import interfacing.NotificationsController;

import javax.crypto.spec.DESedeKeySpec;
import java.awt.*;
import java.util.ArrayList;

public class TotalTest implements CollisionCallback, ButtonCallback {
    private NotificationsController nc;
    private Ultrasone ultrasone;
    private ArrayList<Updatable> devices;
    private Button stopButton;
    private Button resumeButton;
    private Drive drive;

    public static void main(String[] args ) {
        TotalTest main = new TotalTest();
        main.run();
    }

    private void run(){
        for (Updatable devices : this.devices){
            devices.update();
        }
        BoeBot.wait(1);
    }


    public TotalTest () {
        CollisionController collisionController = new CollisionController(this);
        nc = new NotificationsController();
        drive = new Drive();

        this.devices = new ArrayList<>();
        this.devices.add(ultrasone = new Ultrasone(11,10, collisionController));
        this.devices.add(resumeButton = new Button(0, this));
        this.devices.add(stopButton = new Button(1, this));
        }

    @Override
    public void onAlmostCollision() {
        nc.leftWhite();
    }

    @Override
    public void onNearCollision() {
        nc.allRed();
    }

    @Override
    public void isSafe() {
        nc.allGreen();
    }

    @Override
    public void buttonPressed(Button button) {
        if (stopButton == button){
           nc.allBlue();
        }
        if (resumeButton == button){
            nc.allOff();
        }
    }
}

