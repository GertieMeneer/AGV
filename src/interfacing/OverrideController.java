package interfacing;

import TI.BoeBot;
import hardware.additional.Button;

public class OverrideController {

    private int pin;
    private Button button;

    public OverrideController(int pin) {
        this.pin = pin;
        this.button = new Button(this.pin);
    }

    public void checkButton() {
        if(button.check()) {
            emergencyStop();
        }
    }

    private void emergencyStop() {
        Drive drive = new Drive();
        drive.emergencyBrake();
//        drive.open();
        BoeBot.wait(10000);  //for now a wait so that problem can be fixed
    }
}
