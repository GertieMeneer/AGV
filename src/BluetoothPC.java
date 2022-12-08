import hardware.additional.Bluetooth;
import jssc.SerialPort;
import jssc.SerialPortException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BluetoothPC {
    public static void main(String[] args) {
        SerialPort serialPort = new SerialPort("COM8");
        try {
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_115200,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
        } catch (SerialPortException e){
            e.printStackTrace();
        }

        JFrame frame = new JFrame("BoeBot GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        JButton buttonLEDOn = new JButton("LED aan");
        JButton buttonLEDOff = new JButton("LED uit");

        frame.getContentPane().add(BorderLayout.EAST, buttonLEDOn);
        frame.getContentPane().add(BorderLayout.WEST, buttonLEDOff);
        frame.setVisible(true);

        buttonLEDOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    serialPort.writeByte((byte) 100);
                    System.out.println("button geklikt");
                } catch (SerialPortException f) {
                    f.printStackTrace();
                }
            }
        });
        buttonLEDOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    serialPort.writeByte((byte) 50);
                    System.out.println("button geklikt");

                } catch (SerialPortException g) {
                    g.printStackTrace();
                }
            }
        });
    }
}
