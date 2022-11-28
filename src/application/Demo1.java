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
    }

    public Demo1() {
        distanceDrivingDemo();
    }

    public void distanceDrivingDemo() {
        CollisionController collide = new CollisionController();

        while (true) {
            if (collide.isClose()){
                //emergencyBrake();
            } else {
                //deaccelerate;
            }
        }
    }
}



