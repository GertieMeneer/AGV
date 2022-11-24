import TI.BoeBot;
import TI.Servo;
import Hardware.sensors.Ultrasoon;

public class Main {
    public static void main(String[] args) {
//        //put test code here or make new method :D
        while(true) {
//            Servo s1 = new Servo(12);
//            Servo s2 = new Servo(13);
//            s1.update(1500);
//            s2.update(1500);
            testMethode();
        }
    }

    public static void testMethode() {
        boolean driving = false;

        Ultrasoon ultrasoon = new Ultrasoon(1, 0, 1000);

//        LED errorLED = new LED(10,  true);

//        Wheel rightWheel = new Wheel(12);
//        Wheel leftWheel = new Wheel(13);

        Servo rightWheel = new Servo(12);
        Servo leftWheel = new Servo(13);

        if(ultrasoon.checkDistance()) {
            if(!driving) {
                rightWheel.update(2000);
                leftWheel.update(1000);
                driving = true;
            }
//            errorLED.Set(true);
        } else {
            rightWheel.update(1500);
            leftWheel.update(1500);
            driving = false;
//            errorLED.Set(false);
        }

        BoeBot.wait(50);
    }
}