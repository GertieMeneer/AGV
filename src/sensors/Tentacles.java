package sensors;
import TI.BoeBot;

import static TI.PinMode.Input;

public class Tentacles {
    private int GPIOpin;

    public Tentacles(int GPIOpin) {  //here you can create a new tentacle object and assign it to a pin
        this.GPIOpin = GPIOpin;
        BoeBot.setMode(GPIOpin, Input);
    }

    public boolean checkTentacle() {
        return !BoeBot.digitalRead(GPIOpin);
    } //this methode will return true or false depending on the state of the tentacle being pressed or not

}
