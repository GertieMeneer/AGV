package hardwaretests;

import TI.Servo;
import TI.Timer;
import hardware.additional.Button;
import hardware.sensors.Linesensor;
import hardware.sensors.Ultrasone;
import hardware.servos.Wheel;
import interfacing.Drive;

public class TotalTest {
    public static void main(String[] args) {
        new TotalTest();
    }

    Drive drive = new Drive();
    Ultrasone ultrasone = new Ultrasone(11, 10);

    private TotalTest() {
        Timer ultrasoneCheck = new Timer(50);
        Timer linesensorcheck = new Timer(50);
        Timer remotecheck = new Timer(50);
        Button emergencyButton = new Button(0);
        Button resetButton = new Button(1);
        Linesensor rightsensor = new Linesensor(0, "rechts");
        Linesensor leftsensor = new Linesensor(2, "links");
        Servo s1 = new Servo(12);
        Servo s2 = new Servo(13);
        Wheel links = new Wheel(13);
        Wheel rechts = new Wheel(12);


        while (true) {
            if (ultrasoneCheck.timeout()) {
                int translate =  ultrasone.checkDistance();
                if (translate < 500) {
                    drive.emergencyBrake();
                } else if (translate < 1000) {
                    drive.slowStop();
                } else {
                    drive.slowSpeedforward();
//                    System.out.println("update");
                }
                ultrasoneCheck.mark();
            }

//            if (linesensorcheck.timeout()) {
//                if (leftsensor.checkLine() || rightsensor.checkLine()) {
//                    if (rightsensor.checkLine()) {
//                        drive.right();
//                    } else if (leftsensor.checkLine()) {
//                        drive.left();
//                    } else if (rightsensor.checkLine() && leftsensor.checkLine()) {
//                        //Dit betekent dat hij bij een kruispunt staat, hier is victor als het goed is mee bezig
//                    }
//                    drive.slowSpeedforward();
//                    }
//
//                    drive.slowSpeedforward();
//                    linesensorcheck.mark();
//                }
//            }

//                if (remotecheck.timeout()) {
//                    //code met remote, ik weet niet precies hoe dat nu gaat
//                    remotecheck.mark();
//                }

                if (emergencyButton.check()) {
                    while (true) {
                        drive.emergencyBrake();
                        drive.open();

                        if (resetButton.check()) {
                            break;
                        }
                    }
                }
            }
        }

    }
