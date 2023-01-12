package hardwaretests;

import TI.BoeBot;
import interfacing.Drive;

public class ServoWheelsTest {
    private Drive drive;

    public static void main(String[] args) {
        new ServoWheelsTest();
    }


    private ServoWheelsTest() {
        drive = new Drive();

        drive.turnLeft();
        drive.turnRight();


    }
}