import TI.BoeBot;
import TI.PinMode;
import TI.Servo;
import TI.Timer;
import hardware.additional.Button;
import hardware.sensors.Ultrasone;
import hardware.servos.GrabbingCrane;
import hardware.servos.Wheel;
import interfacing.CollisionController;
import interfacing.Drive;
import interfacing.OverrideController;

public class Demo1 {

    public static void main(String[] args) {
        new Demo1();
    }

    public Demo1() {

//        Drive drive = new Drive();

        while (true) {
//            BoeBot.setMode(14, PinMode.Output);
//            Servo g = new Servo(14);
////            g.update(100);
//            for (int i = 500; i < 2000; i++) {
//                g.update(i);
//                System.out.println(i);
//                BoeBot.wait(3);
//            }
            GrabbingCrane crane = new GrabbingCrane(14);
            crane.setTargetAngle(0);
            BoeBot.wait(3000);
            crane.setTargetAngle(2000);
            BoeBot.wait(3000);
//            drive.close();
//            BoeBot.wait(3000);
//            System.out.println(" close");
//            drive.open();
//            BoeBot.wait(3000);
//            System.out.println(" Open");
//            drive.driveForwardSlowSpeed();
//            Servo s1 = new Servo(13);
//            Servo s2 = new Servo(12);
//            Servo s3 = new Servo(14);
//            s1.update(2000);
//            s2.update(1000);
//            BoeBot.wait(10);
        }
    }
}




