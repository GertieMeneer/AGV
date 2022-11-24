package Hardware.additional;

import TI.BoeBot;
import TI.PWM;
import TI.PinMode;

public class LED {

    boolean isPWM;
    int pwmValue;
    boolean isOn;
    int pin;

//  you can initiate this class with a boolean or an integer.
//  if you put in an integer, it becomes scalable and if you put in a boolean, the LED will become either on or off
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

//    with the set Method you can also choose to put in either a boolean or an integer.
//    the set method can also change the LED to the other mode if the other value

    public void Set (boolean power){
        if (isPWM == true){
            BoeBot.setMode(pin, PinMode.Output);
            isPWM = false;
        }
        BoeBot.digitalWrite(this.pin, power);
    }

    public void Set (int power){
        if (isPWM == false){
            BoeBot.setMode(pin, PinMode.PWM);
            isPWM = true;
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
