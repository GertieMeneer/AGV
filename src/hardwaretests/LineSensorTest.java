package hardwaretests;

import TI.BoeBot;
import hardware.LineCallback;
import hardware.PathTrackerCallback;
import hardware.sensors.Linesensor;

import java.awt.*;

public class LineSensorTest implements LineCallback {


    private Linesensor leftsensor;
    private Linesensor rightsensor;

    public LineSensorTest(){
        leftsensor = new Linesensor(2,this );
        rightsensor = new Linesensor(0, this);
    }

    public static void main(String[] args) {
        LineSensorTest lineSensorTest = new LineSensorTest();
        lineSensorTest.run();
    }

    private void run() {
        while (true){
            leftsensor.update();
            rightsensor.update();

            BoeBot.wait(1);
        }

    }

    @Override
    public void onMeasure(Linesensor linesensor) {
        if (leftsensor == linesensor){
            BoeBot.rgbSet(3, Color.orange);
            BoeBot.rgbShow();
        }else{
            BoeBot.rgbSet(3, Color.BLACK);
            BoeBot.rgbShow();
        }

        if (rightsensor == linesensor){
            BoeBot.rgbSet(5, Color.orange);
            BoeBot.rgbShow();
        }else{
            BoeBot.rgbSet(5, Color.BLACK);
            BoeBot.rgbShow();
        }
    }
}
