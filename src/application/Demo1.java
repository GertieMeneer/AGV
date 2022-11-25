package application;

import TI.BoeBot;
import TI.Timer;
import hardware.sensors.Ultrasone;
import interfacing.CollisionController;
import interfacing.Drive;
import hardware.servos.GrabbingCrane;
import interfacing.NotificationsController;

public class Demo1 {

    public static void main(String[] args) {
        new Demo1();

//        distanceDrivingDemo();          //demo for driving and stopping when object
//        BoeBot.wait(1000);
//        grabingCraneDemo();             //demo for grabingcrane: opening/closing slowely and fast
//        Wheel.ForwardAcceleratingMaxSpeed();
//        distanceDrivingDemo();
    }

    public Demo1() {
        distanceDrivingDemo();
    }

    public void distanceDrivingDemo() {
        CollisionController collide = new CollisionController();

        while (true) {
            if (collide.isClose()){
                //emergencyBrake();
            }
            if(!collide.isClose()){
                //deaccelerate;
            }
        }
    }

    public void grabingCraneDemo() {
        GrabbingCrane crane = new GrabbingCrane(14);
        crane.open();
        BoeBot.wait(1000);
        crane.slowlyClose();
        BoeBot.wait(1000);
        crane.slowlyOpen();
        BoeBot.wait(1000);
        crane.close();
        BoeBot.wait(1000);
    }
}



