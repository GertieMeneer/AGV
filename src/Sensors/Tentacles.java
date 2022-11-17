package Sensors;

public class Tentacles {
    private int GPIOpin;

    public Tentacles(int GPIOpin) {
        this.GPIOpin = GPIOpin;
        BoeBot.setMode(GPIOpin, Input);
    }

    private boolean checkTentacle() {
        if(BoeBot.digitalRead(GPIOpin) == true) {
            return true;
        } else {
            return false;
        }
    }
}
