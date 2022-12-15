package interfacing;

import TI.BoeBot;
import hardware.additional.Button;
import hardware.sensors.IR;

public class OverrideController {

    private int brakePin;
    private Button button;
    private int irPin;
    IR remote = new IR(irPin);
    private boolean inUse = false;
    NotificationsController light = new NotificationsController();

    public OverrideController(int brakePin, int irPin) {
        this.brakePin = brakePin;
        this.button = new Button(this.brakePin);
        this.irPin = irPin;
    }

    public void checkButton() {
        if(button.check()) {
            emergencyStop();
        }
    }

    private void emergencyStop() {
        Drive drive = new Drive();
        drive.emergencyBrake();
//        drive.open();
        BoeBot.wait(10000);  //for now a wait so that problem can be fixed
    }

    public void irControl(){
        Drive drive = new Drive();
        if (remote.readIR() != 0) {inUse = true;}
        while (remote.readIR() != 0 && inUse == true){
            //on/off
            if (remote.readIR() == 149){

            }
            //mute
            if (remote.readIR() == 149){

            }
            //CH+
            if (remote.readIR() == 144){
                light.allGreen();
            }
            //CH-
            if(remote.readIR() == 145){
                light.allOff();
            }
            //vol+
            if (remote.readIR() == 146){

            }
            //vol-
            if (remote.readIR() == 147){

            }
            //1
            if (remote.readIR() == 128){

            }
            //2
            if (remote.readIR() == 129){

            }
            //3
            if (remote.readIR() == 130){

            }
            //4
            if (remote.readIR() == 131){

            }
            //5
            if (remote.readIR() == 132){

            }
            //6
            if (remote.readIR() == 133){

            }
            //7
            if (remote.readIR() == 134){

            }
            //8
            if (remote.readIR() == 135){

            }
            //9
            if (remote.readIR() == 136){

            }
            //0
            if (remote.readIR() == 137){

            }
            //Enter
            if (remote.readIR() == 140){

            }
            //AB
            if (remote.readIR() == 165){

            }
            //Pause
            //doesn't give signal
            //Stop
            if (remote.readIR() == 461){

            }
            //Record
            if (remote.readIR() == 157){

            }
            //square
            if (remote.readIR() == 184){

            }
            //backwards
            if (remote.readIR() == 460){

            }
            //Play
            if (remote.readIR() == 462){

            }
            //Forward
            if (remote.readIR() == 463){

            }
            //Three striped Square
            if (remote.readIR() == 191){

            }
            //^
            if (remote.readIR() == 158){

            }
            //v
            if (remote.readIR() == 159){

            }
            //>
            if (remote.readIR() == 154){

            }
            //<
            if (remote.readIR() == 155){

            }
            //OK
            //doesn't give signal
            //That weird One
            if (remote.readIR() == 458){

            }
            //Square with Three Stripes like Stairs
            if (remote.readIR() == 157){

            }
            //Menu
            if (remote.readIR() == 224){

            }
            //Exit
            if (remote.readIR() == 457){

            }


        }

    }
}
