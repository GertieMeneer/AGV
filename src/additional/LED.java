package additional;

import TI.BoeBot;
import TI.PWM;
import TI.PinMode;

public class LED {

    boolean isPWM;
    int pwmValue;
    boolean isOn;
    int pin;


    public LED (int pin, boolean power){
        this.isOn = power;
        this.pin = pin;
        isPWM = false;
        BoeBot.setMode(pin, PinMode.Output);
        BoeBot.digitalWrite(pin, power);
    }

    public LED (int pin, int power){
        this.pwmValue = power;
        this.pin = pin;
        isPWM = true;
        BoeBot.setMode(pin, PinMode.PWM);
        PWM led = new PWM(pin, power);
    }

    public void Set (boolean power){
        if (isPWM == true){
            BoeBot.setMode(pin, PinMode.Output);
        }
        BoeBot.digitalWrite(this.pin, power);
    }

    public void Set (int power){
        if (isPWM == false){
            BoeBot.setMode(pin, PinMode.PWM);
        }
        PWM led = new PWM(pin, power);
    }


//    public boolean getPower (){
//        if (isPWM == false){
//            return isOn;
//        }
//    }
//
//    public int getPower(){
//        if (isPWM == true){
//            return pwmValue;
//        }
//    }



}
