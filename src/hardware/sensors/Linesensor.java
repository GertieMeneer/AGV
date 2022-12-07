package hardware.sensors;

import TI.BoeBot;

public class Linesensor {

    private String position;
    private int pin;

    public Linesensor(int pin, String position) {
        this.pin = pin;
        this.position = position;
    } //linkerlijnvolger ADC 2 , middelste ADC 1 , rechter ADC 0.

    public boolean checkLine() {
        int sensorValue = BoeBot.analogRead(this.pin);  //reads the sensor value from given pin
        if(sensorValue > 900) {
            return true;
        }

        return false;
    }
}
