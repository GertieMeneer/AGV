import TI.BoeBot;
import TI.Timer;
import hardware.sensors.Ultrasone;
import hardware.servos.Wheel;
import interfacing.CollisionController;
import interfacing.Drive;
import interfacing.OverrideController;

public class Demo1 {

    public static void main(String[] args) {
        new Demo1();
    }

    public Demo1() {
        Drive drive = new Drive();
        Ultrasone ultrasone = new Ultrasone(11, 10);

        while (true) {
            System.out.println(ultrasone.checkDistance());
            BoeBot.wait(100);
        }
    }
}




