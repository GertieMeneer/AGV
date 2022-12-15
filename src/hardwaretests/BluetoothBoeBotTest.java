package hardwaretests;

import TI.BoeBot;
import TI.SerialConnection;

public class BluetoothBoeBotTest {
    public static void main(String[] args) {
        SerialConnection serial = new SerialConnection(115200);

        while(true) {
            if (serial.available() > 0) {
                int data = serial.readByte();
                serial.writeByte(data);
                System.out.println("Received: " + data);
            }
            BoeBot.wait(10);
        }
    }

}
