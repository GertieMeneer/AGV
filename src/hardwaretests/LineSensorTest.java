package hardwaretests;

import TI.BoeBot;
import hardware.PathTrackerCallback;

public class LineSensorTest implements PathTrackerCallback {
    public static void main(String[] args) {
        while(true) {
            int sensorValue = BoeBot.analogRead(0);
            System.out.println(sensorValue);
            BoeBot.wait(500);
        }
    }

    @Override
    public void seeLine() {

    }
}
