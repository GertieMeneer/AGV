package hardwaretests;

import TI.BoeBot;

public class LineSensorTest {
    public static void main(String[] args) {
        while(true) {
            int sensorValue = BoeBot.analogRead(0);
            System.out.println(sensorValue);
            BoeBot.wait(500);
        }
    }
}
