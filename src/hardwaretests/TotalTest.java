package hardwaretests;

import TI.BoeBot;
import TI.Timer;
import hardware.additional.Button;
import hardware.sensors.Linesensor;
import hardware.sensors.Ultrasone;
import interfacing.CollisionController;
import interfacing.Drive;
import interfacing.NotificationsController;

public class TotalTest {
    public static void main(String[] args ) {
        new TotalTest();

    }


    private TotalTest () {
        Drive drive = new Drive();
        NotificationsController nc = new NotificationsController();
        Timer ultrasoneCheck = new Timer(50);
        Timer linesensorcheck = new Timer(50);
        Timer remotecheck = new Timer(50);
        boolean redlighton = false;


        while (true) {
            if( ultrasoneCheck.timeout()) {
                UltrasonicTest main = new UltrasonicTest();
                main.run();
//                if() {          //check voor de afstand ultrasone close
//                    drive.emergencyBrake();
//                    nc.allRed();
//                    redlighton = true;
//                } else if() {   //check voor afstand ultrasone sortofclose
//                    drive.slowStop();
//                    nc.allRed();
//                    redlighton = true;
//                } else {
//                    if(redlighton) {
//                        BoeBot.wait(1000);
//                        nc.forwardWhite();
//                        drive.slowSpeedforward();
//                        redlighton = false;
//                    }
//                }
            }

            BoeBot.wait(1);
        }
    }

}
