package hardware.sensors;

import TI.BoeBot;
import TI.PinMode;

import java.util.ArrayList;

public class IR {

    private int pin1;
    private int pin2;

    public IR(int pin1, int pin2) {
        this.pin1 = pin1;
        this.pin2 = pin2;
        BoeBot.setMode(pin1, PinMode.Input);
        BoeBot.setMode(pin2, PinMode.Output);
    }

    public int readIR() {
        //returns value received by IR
        int number = 0;
        int pulselength = BoeBot.pulseIn(pin1, false, 6000);
        if (pulselength > 2000){
            int lengths[] = new int[12];
            for (int i = 0; i < 12; i++) {
                lengths[i] = BoeBot.pulseIn(0, false, 20000);
            }

            return translate(lengths);
        }
        return 0;
    }

    private static int translate (int values[]){
        int number = 0;
        int bitCounter = 1;
        ArrayList<Integer> name = new ArrayList<>();
        for (int value : values) {
            if (value > 1000){
                name.add(1);
            } else if (value < 1000 && value > 0){
                name.add(0);
            } else{
                name.add(-1);
            }
        }

        for (Integer value : name) {
            number += value * bitCounter;
            bitCounter = bitCounter + 8;
        }

        return number;
    }
}
