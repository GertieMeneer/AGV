package Hardware.additional;

import TI.BoeBot;

public class Speaker {
    private int pin;

    public Speaker(int pin) {
        this.pin = pin;
    }

    public void playSound(int frequency, int time) {
        BoeBot.freqOut(pin, frequency, time);
    }
}
