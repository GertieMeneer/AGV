package Sensors;
import TI.BoeBot;
import TI.*;

import static TI.PinMode.Input;

public class Tentacles {
    private int GPIOpin;

    public Tentacles(int GPIOpin) {
        this.GPIOpin = GPIOpin;
        BoeBot.setMode(GPIOpin, Input);
    }

    public boolean checkTentacle() {
        return BoeBot.digitalRead(GPIOpin);
    }
}
