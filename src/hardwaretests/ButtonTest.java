package hardwaretests;

import TI.BoeBot;
import hardware.ButtonCallback;
import hardware.OverrideCallback;
import hardware.Updatable;
import hardware.additional.Button;
import interfacing.NotificationsController;
import java.util.ArrayList;

public class ButtonTest implements ButtonCallback {
    private Button brakeButton;
    private Button resumeButton;
    private ArrayList<Updatable> devices;
    private NotificationsController nc;

    public static void main(String[] args) {
        ButtonTest buttonTest = new ButtonTest();
        buttonTest.run();
    }

    private ButtonTest() {
        devices = new ArrayList<>();

        nc = new NotificationsController();

        devices.add(resumeButton = new Button(0, this));
        devices.add(brakeButton = new Button(1, this));

    }

    private void run() {
        while (true) {
            for (Updatable device : devices) {
                device.update();
            }
            BoeBot.wait(1);
        }
    }

    @Override
    public void buttonPressed(Button button) {
        if (button == brakeButton){
            nc.allRed();
        }
        if (button == resumeButton){
            nc.allGreen();
        }
    }
}
