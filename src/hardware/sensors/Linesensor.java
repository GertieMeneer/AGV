package hardware.sensors;

import TI.BoeBot;
import hardware.LineCallback;
import hardware.Updatable;

public class Linesensor {

    private int pin;
    private LineCallback callback;

    public Linesensor(int pin, LineCallback callback) {
        this.pin = pin;
        this.callback = callback;
    } //linkerlijnvolger ADC 2, rechter ADC 0.


    public int update() {
        //reads the sensor value from given pin and sends it to the pathtracker
        return BoeBot.analogRead(this.pin);
    }
}
