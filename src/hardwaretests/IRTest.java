package hardwaretests;

import TI.BoeBot;
import TI.PinMode;

public class IRTest {
    public static void main(String[] args) {
        BoeBot.setMode(0, PinMode.Input);
        BoeBot.setMode(6, PinMode.Output);

        System.out.println("Listening...");
        while(true) {
            int pulseIn = BoeBot.pulseIn(0, false, 6000);
            if (pulseIn > 2000) {
                int lengths[] = new int[12];
                for (int i = 0; i < 12; i++) {
                    lengths[i] = BoeBot.pulseIn(0, false, 20000);
                }

                for (int length: lengths) {
                    System.out.println(length + ", ");
                }
                System.out.println("");
            }
            BoeBot.wait(10);
        }
    }
}
