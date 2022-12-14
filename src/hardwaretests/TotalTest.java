package hardwaretests;

import TI.Timer;
import hardware.additional.Button;
import hardware.sensors.Linesensor;
import hardware.sensors.Ultrasone;
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
        Linesensor rightsensor = new Linesensor(0, "rechts");
        Linesensor leftsensor = new Linesensor(2, "links");


        while (true) {
            if (ultrasoneCheck.timeout()) {
                if (ultrasone.checkDistance() < 500) {
                    drive.emergencyBrake();
                } else if (ultrasone.checkDistance() < 1000) {
                    drive.setSpeedForward(0);
                } else {
                    drive.setSpeedForward(1000);
                }
                ultrasoneCheck.mark();
            }

            if (linesensorcheck.timeout()) {
                if (leftsensor.checkLine() || rightsensor.checkLine()) {
                    if (rightsensor.checkLine()) {
                        drive.left();
                    } else if (leftsensor.checkLine()) {
                        drive.left();
                    } else if (rightsensor.checkLine() && leftsensor.checkLine()) {
                        //Dit betekent dat hij bij een kruispunt staat, hier is victor als het goed is mee bezig
                    }
                    drive.slowSpeedforward();
                }
                linesensorcheck.mark();
            }

            if (remotecheck.timeout()) {
                //code met remote, ik weet niet precies hoe dat nu gaat
                remotecheck.mark();
            }

            if(emergencyButton.check()) {
                drive.emergencyBrake();
                drive.open();
            }

            //ir pin 2,
        }
    }

}
