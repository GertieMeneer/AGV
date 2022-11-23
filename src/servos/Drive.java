package servos;

import TI.*;

public class Drive {
    private Servo rightWheel = new Servo(12);
    private Servo leftWheel = new Servo(13);
    private int restMode = 1500;

    public Drive() {
    }

//    public boolean isInside() {
//        return false;
//    }


    private int speed() {

//        if (isInside()) {          Dit is het idee voor later.
//            return 40;
//        } else {
//            return 200;
//        }
        return 40;
    }

    public void dirveForwards() {

        this.leftWheel.update(this.restMode + speed());
        this.rightWheel.update(this.restMode - speed());
    }

    public void driveBackwards(){

        this.leftWheel.update(this.restMode - speed());
        this.rightWheel.update(this.restMode + speed());
    }

    public void emergencyBrake() {

        this.leftWheel.update(this.restMode);
        this.rightWheel.update(this.restMode);
    }
}
