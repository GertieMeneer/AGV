package hardware.additional;

import TI.BoeBot;
import TI.PinMode;
import hardware.ButtonCallback;
import hardware.Updatable;

public class Button implements Updatable {
    private int pin;
    private ButtonCallback callback;
    private boolean isPressed = false;

    public Button(int pin, ButtonCallback callback) {
        this.pin = pin;
        this.callback = callback;
        BoeBot.setMode(this.pin, PinMode.Input);
    }

    @Override
    public void update() {
        boolean newIsPressed = !BoeBot.digitalRead(this.pin);

        if (newIsPressed && !isPressed){
            callback.buttonPressed(this);
        }

        isPressed = newIsPressed;
    }
}
