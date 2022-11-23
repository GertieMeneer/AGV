import TI.BoeBot;
import additional.LED;
import sensors.Ultrasoon;
import servos.GrabingCrane;
import servos.Wheel;

import java.awt.image.PixelGrabber;

public class TestingGround {
    public static void main(String[] args) {
        //put test code here or make new method :D
        GrabingCrane.close();
        BoeBot.wait(1000);
        GrabingCrane.slowlyOpen();
        BoeBot.wait(1000);
        GrabingCrane.slowlyclose();
    }

//    public static void testMethode() {
//        Ultrasoon ultrasoon = new Ultrasoon(9, 10);
//
//        LED errorLED = new LED(0,  true);
//
//        Wheel rightWheel = new Wheel(12);
//        Wheel leftWheel = new Wheel(13);
//
//        if(ultrasoon.checkDistance()) {
//            rightWheel.emergencyBrake();
//            leftWheel.emergencyBrake();
//            errorLED.Set(true);
//        } else {
//            rightWheel.rollForwards();
//            leftWheel.rollForwards();
//            errorLED.Set(false);
//        }
//
//        BoeBot.wait(50);
//    }


}
