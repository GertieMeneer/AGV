package hardware.sensors;

import TI.BoeBot;
import TI.PinMode;
import TI.Timer;
import hardware.SensorCallback;
import hardware.Updatable;

public class IR implements Updatable {
    private int pin;
    private SensorCallback callback;
    private Timer timer;

    public IR(int pin1, SensorCallback callback) {
        this.pin = pin1;
        BoeBot.setMode(pin1, PinMode.Input);
        BoeBot.setMode(6, PinMode.Output);
        this.callback = callback;
        this.timer = new Timer(10);
    }

    @Override
    public void update() {
            if (timer.timeout()) {
                int pulseIn = BoeBot.pulseIn(pin, false, 6000);
                if (pulseIn > 2000) {
                    int lengths[] = new int[7];
                    for (int i = 0; i < 7; i++) {
                        lengths[i] = BoeBot.pulseIn(pin, false, 20000);
                    }

                    int number = 0;
                    int bitCounter = 1;

                    for (int length : lengths) {        //  this turns the binary number into a decimal number
                        if (length > 1000) {
                            length = bitCounter;
                            number = number + length;
                        }
                        if (length < 0) {
                            number = -1;
                        }
                        bitCounter *= 2;
                    }
                    System.out.println(number);
                    this.callback.onMeasure(number); // this is what the Callback will use to measure the signal
                }
            }
        }
    }