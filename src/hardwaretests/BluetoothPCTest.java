package hardwaretests;

import jssc.SerialPort;
import jssc.SerialPortException;

public class BluetoothPCTest {
    private static final String port = "COM4";
    public static void main(String[] args) {
        SerialPort serialPort = new SerialPort(port);
        try {
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_115200,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            serialPort.writeString("Hello world!");

            byte[] buffer = serialPort.readBytes(10);
            for (int i = 0; i < 10; i++) {
                System.out.println(buffer[i] + "-");
                serialPort.closePort();
                }
            } catch (SerialPortException e) {
                e.printStackTrace();
            }
        }
    }

