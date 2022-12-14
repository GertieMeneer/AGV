package hardwaretests;

import TI.BoeBot;
import TI.Servo;
import TI.Timer;
import hardware.servos.Wheel;
import interfacing.Drive;

public class ServoWheelsTest {
    private Drive drive;
    public static void main(String[] args) {
        new ServoWheelsTest();
    }


    private ServoWheelsTest() {
        Timer t1 = new Timer(5000);
        t1.mark();

        while(true) {
            if(t1.timeout()) {
                drive.setSpeedForward(500);
                BoeBot.wait(5000);
                t1.mark();
            }
            drive.setSpeedForward(1000);
            BoeBot.wait(10);
        }
    }
}
