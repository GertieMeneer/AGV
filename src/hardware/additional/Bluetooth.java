package hardware.additional;

import TI.SerialConnection;
import interfacing.NotificationsController;
import jssc.SerialPort;
import jssc.SerialPortException;

public class Bluetooth {
    SerialConnection serial = new SerialConnection(115200);
    NotificationsController LEDController = new NotificationsController();

    public void readBluetoothModule() {
        if (serial.available() > 0) {
            System.out.println("yesss yess yess concecten dsucsjlefysy6");
            int data = serial.readByte();
            System.out.println(data);

            if(data == 100) {
                LEDController.allBlue();
            }
            if(data == 50) {
                LEDController.allBlack();
            }
        }
    }
}
