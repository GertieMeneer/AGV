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
        //IR ir = new IR(2);
        int pulseLen = BoeBot.pulseIn(2, false, 6000);
//        System.out.println(pulseLen);
        if (pulseLen > 2000) {
            int lengths[] = new int[12];
            for (int i = 0; i < 12; i++) {
                lengths[i] = BoeBot.pulseIn(2, false, 20000);
            }

            this.number = translate(lengths);
            System.out.println(this.number);
            return number;
        } else {return 0;}


    }

    public int[] readIRLes() {
        IR ir = new IR(2);
        System.out.println("Listening....");
        while (true) {
            int pulseLen = BoeBot.pulseIn(2, false, 6000);
            System.out.println(pulseLen);
            if (pulseLen > 2000) {
                int lengths[] = new int[12];
                for (int i = 0; i < 12; i++) {
                    lengths[i] = BoeBot.pulseIn(2, false, 20000);
                }

                number = ir.translate(lengths);
            }
            BoeBot.wait(10);
        }
    }

//    private int translate (int values[]){
//        int number = 0;
//        int bitCounter = 1;
//        ArrayList<Integer> names = new ArrayList<>();
//        for (int value : values) {
//            if (value > 1000){
//                names.add(1);
//            } else if (value < 1000 && value > 0){
//                names.add(0);
//            } else{
//                names.add(-1);
//            }
//        }
//
//        for (Integer name : names) {
//            number += name * bitCounter;
//            bitCounter = bitCounter + 8;
//        }
//        if(number < 0) {
//            return 0;
//        }
//
//        return number;
//    }

    private int translate (int values[]) {
        int number = 0;
        int bitCounter = 1;
        for (int value : values) {
            if (value > 1000){
                number|=bitCounter;
            }
            if (value < 0){
                return 0;
            }
            bitCounter <<= 1;
        }
        return number;
    }
}
