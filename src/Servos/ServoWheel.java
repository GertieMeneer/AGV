package Servos;
import TI.BoeBot;
import TI.*;

public class ServoWheel {
    private Servo leftWheel = new Servo(12);
    private Servo rightWheel = new Servo(13);
    private boolean isInside;

    public ServoWheel(){}



    public void driveForwards(){
        if(this.isInside){
            this.leftWheel.update(1700);
            this.rightWheel.update(1300);
        }else{
            this.leftWheel.update(1550);
            this.rightWheel.update(1450);
        }

    }
}
