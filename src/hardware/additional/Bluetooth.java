package hardware.additional;

import TI.SerialConnection;
import interfacing.NotificationsController;

public class Bluetooth {
    SerialConnection serial = new SerialConnection(115200);
    NotificationsController controller = new NotificationsController();

    public void readBluetoothModule() {
        if (serial.available() > 0) {
            int data = serial.readByte();
            System.out.println(data);
            if(data == 100) {
                controller.allBlue();
            }
            if(data == 50) {
                controller.allOff();
            }
        }
    }
}
