package userinterface;

import jssc.SerialPort;
import jssc.SerialPortException;

public class BoeBotConnection {
    SerialPort serialPort;

    public BoeBotConnection() {
        serialPort = new SerialPort("COM5");
        try {
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_115200,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
        } catch (SerialPortException e){
            System.out.println("Verbinding met BoeBot mislukt :(");
        }
    }

    public void sendRoute(String route) {
        try {
            serialPort.writeString(route);
        } catch (SerialPortException f) {
            System.out.println("Versturen van de route naar BoeBot mislukt :(");
        }
    }


}
