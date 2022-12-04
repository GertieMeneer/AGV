package hardware.sensors;

public class IR {

    private int pin;

    public IR(int pin) {
        this.pin = pin;
    }

    public boolean receivesSignal() {
        //checks for IR pulse, if a pulse: read the pulse, then take action
        return false;
    }

    public int readIR() {
        //reads IR value if pulse detected
        return 0;
    }
}
