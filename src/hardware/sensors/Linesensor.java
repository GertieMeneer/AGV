package hardware.sensors;

import TI.BoeBot;

public class Linesensor {

    private int pin;

    public Linesensor(int pin) {
        this.pin = pin;
    } //linkerlijnvolger ADC 2 , middelste ADC 1 , rechter ADC 0.

    public boolean checkLine() {
        int sensorValue = BoeBot.analogRead(this.pin);  //reads the sensor value from given pin
        if (sensorValue > 900) {        //checks for a line and returns true when there is one
            return true;
        }
        return false;
    }
}