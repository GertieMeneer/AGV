package interfacing;

import hardware.additional.Bluetooth;
import hardware.additional.LED;

public class BluetoothController {

    private Bluetooth bluetooth = new Bluetooth();

    public void readBluetooth() {
        bluetooth.readBluetoothModule();
    }

}
