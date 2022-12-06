package hardware.additional;

import TI.BoeBot;
import TI.PinMode;

public class Button {
    private int pin;

    public Button(int pin) {
        this.pin = pin;
    }

    public boolean check() {
        BoeBot.setMode(this.pin, PinMode.Input);

        if (BoeBot.digitalRead(this.pin)) {
            return true;
        } else {
            return false;
        }
    }
}
