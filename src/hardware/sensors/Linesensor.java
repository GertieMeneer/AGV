package hardware.sensors;

import TI.BoeBot;
import hardware.LineCallback;
import hardware.Updatable;

public class Linesensor implements Updatable {

    private int pin;
    private LineCallback callback;
    private boolean seesLine;

    public Linesensor(int pin, LineCallback callback) {
        this.pin = pin;
        this.callback = callback;
    } //linkerlijnvolger ADC 2 , middelste ADC 1 , rechter ADC 0.


    @Override
    public void update() {

        int sensorValue = BoeBot.analogRead(this.pin); //reads the sensor value from given pin
        System.out.println(sensorValue);
        if (sensorValue > 900){ // if the value of the sensor is higher than 900, the sensor sees a line.
            seesLine = true;
        }

        if (seesLine) {
            this.callback.onMeasure(this);
        }
    }
}
