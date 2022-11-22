package servos;

import TI.*;

public class Wheel {
    private int GPIOpin;
    private Servo wheel = new Servo(this.GPIOpin);

    public Wheel(int GPIOpin) {
        this.GPIOpin = GPIOpin;
    }

//    public boolean isInside() {
//        return false;
//    }


    public int speed() {

//        if (isInside()) {          Dit is het idee voor later.
//            return 40;
//        } else {
//            return 200;
//        }
        return 40;
    }

    public void rollForwards() {

        if (this.GPIOpin == 12) {                    // niet robuust, maar ik kon geen andere manier bedenken.
            this.wheel.update(1500 - speed());
        } else if (this.GPIOpin == 13) {
            this.wheel.update(1500 + speed());
        }
    }

    public void emergencyBrake() {
        this.wheel.update(1500);
    }
}
