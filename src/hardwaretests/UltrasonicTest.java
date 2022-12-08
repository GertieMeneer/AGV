package hardwaretests;

import TI.BoeBot;
import TI.PinMode;

public class UltrasonicTest {
    public static void main(String[] args) {
        BoeBot.setMode(11, PinMode.Input);
        BoeBot.setMode(10, PinMode.Output);

        System.out.println("Starting...");
        while(true) {
            BoeBot.digitalWrite(10, true);
            BoeBot.wait(10); //or uwait if it dont work
            BoeBot.digitalWrite(10, false);

            int pulse = BoeBot.pulseIn(11, true, 10000);
            System.out.println("Pulse: " + pulse);
            BoeBot.wait(50);
        }
    }
}
