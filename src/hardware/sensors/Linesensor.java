package hardware.sensors;

import TI.BoeBot;
import hardware.SensorCallback;
import hardware.Updatable;

public class Linesensor implements Updatable {

    private String position;
    private int pin;
    private SensorCallback callback;

    public Linesensor(int pin, SensorCallback callback) {
        this.pin = pin;
        this.position = position;
        this.callback = callback;
    } //linkerlijnvolger ADC 2 , middelste ADC 1 , rechter ADC 0.


    @Override
    public void update() {
        int sensorValue = BoeBot.analogRead(this.pin);  //reads the sensor value from given pin
        this.callback.onMeasure(sensorValue);
    }
}
