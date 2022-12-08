package interfacing;

import hardware.additional.Bluetooth;
import hardware.additional.LED;

public class BluetoothController {

    private String port;
    private Bluetooth bluetooth = new Bluetooth();
    private LED led;

    public BluetoothController(String port) {
    }

    public void readBluetooth() {
        bluetooth.readBluetoothModule();
    }

}
