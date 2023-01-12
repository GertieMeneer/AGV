package hardwaretests;

import TI.BoeBot;
import hardware.LineCallback;
import hardware.PathTrackerCallback;
import hardware.sensors.Linesensor;
import interfacing.Drive;
import interfacing.PathTracker;

import java.awt.*;

public class LineSensorTest implements LineCallback {


    private Linesensor leftsensor;
    private Linesensor rightsensor;
    private Drive drive;


    public LineSensorTest(){
        leftsensor = new Linesensor(2,this );
        rightsensor = new Linesensor(0, this);
        drive = new Drive();

    }

    public static void main(String[] args) {
        LineSensorTest lineSensorTest = new LineSensorTest();
        lineSensorTest.run();
    }

    private void run() {
//        while (true){
//            int rightValue =  rightsensor.update();
//            System.out.println(rightValue);
//            int leftValue = leftsensor.update();
//            System.out.println(leftValue);
//
//            if(rightValue > 900 || leftValue > 900) {
//                if(rightValue > 900 && leftValue <= 900) {
//                    System.out.println("Go left");
//                    drive.left();
////                    LineSensorChanged =  true;
//                }
//
//                if(leftValue > 900 && rightValue <= 900) {
//                    System.out.println("Go right");
//                    drive.right();
////                    LineSensorChanged =  true;
//                }
//
//                if(leftValue > 900 && rightValue >900) {
//                    //shit met de navigate
//                    drive.setSpeed(20);
////                    LineSensorChanged = true;
//                }
//            } else {
////                LineSensorChanged = false;
//                drive.setSpeed(20);
//            }
//
//            drive.update();
//            BoeBot.wait(50);
//        }
        int random = -rightsensor.update();
        System.out.println(random);
        System.out.println(-random);

    }

    @Override
    public void onMeasure() {

    }


//    @Override
//    public void onMeasure(Linesensor linesensor) {
//        if (leftsensor == linesensor){
//            BoeBot.rgbSet(3, Color.orange);
//            BoeBot.rgbShow();
//        }else{
//            BoeBot.rgbSet(3, Color.BLACK);
//            BoeBot.rgbShow();
//        }
//
//        if (rightsensor == linesensor){
//            BoeBot.rgbSet(5, Color.orange);
//            BoeBot.rgbShow();
//        }else{
//            BoeBot.rgbSet(5, Color.BLACK);
//            BoeBot.rgbShow();
//        }
//    }
}
