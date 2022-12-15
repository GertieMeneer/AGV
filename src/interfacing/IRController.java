package interfacing;

import hardware.sensors.IR;

public class IRController {

    private IR ir;
    public IRController(int pin) {
        ir = new IR(pin);
    }

    public void readIR() {
        ir.readIRLes();
        if(ir.readIRLes() == 10) {

        }
    }
}
