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
        Drive drive = new Drive();
        Wheel leftWheel = new Wheel(12);
        Timer t1 = new Timer(5000);
        Servo servo = new Servo(12);
        t1.mark();

        while (true) {
            drive.slowSpeedforward();

            if (t1.timeout()){
                drive.slowStop();
            }
            BoeBot.wait(50);
        }
    }

    public void update() {

    }
}