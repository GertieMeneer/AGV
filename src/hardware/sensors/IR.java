package hardware.sensors;

import TI.BoeBot;
import TI.PinMode;

import java.util.ArrayList;

public class IR {
    private int number;

    private int pin;

    public IR(int pin1) {
        this.pin = pin;
        BoeBot.setMode(pin1, PinMode.Input);
        BoeBot.setMode(6, PinMode.Output);

    }

    public int readIR() {
        //returns value received by IR
        int number = 0;
        int pulselength = BoeBot.pulseIn(pin, false, 6000);
//        System.out.println(pulselength);
        if (pulselength < 2000){
            System.out.println();
            int lengths[] = new int[12];
            for (int i = 0; i < 12; i++) {
                lengths[i] = BoeBot.pulseIn(pin, false, 20000);
            }
//            number = translate(lengths);
            System.out.println(lengths);
            return number;
        }else{
            return 0;
        }

    }

    public int[] readIRLes() {
        IR ir = new IR(2);
        System.out.println("Listening....");
        while (true) {
            int pulseLen = BoeBot.pulseIn(2, false, 6000);
            if (pulseLen > 2000) {
                int lengths[] = new int[12];
                for (int i = 0; i < 12; i++) {
                    lengths[i] = BoeBot.pulseIn(2, false, 20000);
                }

                number = ir.translate(lengths);
            }
        }
    }

    private int translate (int values[]){
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
        System.out.println(name);



        for (Integer value : name) {
            number += value * bitCounter;
            bitCounter = bitCounter + 8;
        }
        if(number < 0) {
            return 0;
        }
        System.out.println(number);

        return number;
    }
}
