package hardware.additional;

import TI.BoeBot;

public class Button {
    private int pin;

    public Button(int pin) {
        this.pin = pin;
    }

    public boolean check() {
        if (BoeBot.digitalRead(this.pin)) {
            return true;
        } else {
            return false;
        }
    }
}
