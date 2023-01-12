package userinterface;

import javafx.scene.control.Alert;
import jssc.SerialPort;
import jssc.SerialPortException;

public class BoeBotConnection {
    private SerialPort serialPort;

    public BoeBotConnection() {

        serialPort = new SerialPort("COM5"); //try opening serial port via bluetooth device
        try { //settings properties for serialport
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_115200,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
        } catch (SerialPortException e){
            showError("Verbinding met BoeBot mislukt :("); //printing error when unsuccessfull
        }
    }

    public void sendRoute(String route) {
        try {
            serialPort.writeString(route); //sending route as string to serialport
        } catch (SerialPortException f) {
            showError("Versturen van de route naar BoeBot mislukt :(");
        }
    }

    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("Er is een fout opgetreden :(");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
