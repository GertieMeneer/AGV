import TI.BoeBot;
import TI.Timer;
import hardware.additional.Button;
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
        Button button = new Button(0);

        while (true) {
            System.out.println(button.check());
            BoeBot.wait(10);
        }
    }
}




