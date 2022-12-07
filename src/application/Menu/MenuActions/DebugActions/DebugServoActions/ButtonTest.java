package application.Menu.MenuActions.DebugActions.DebugServoActions;

import TI.BoeBot;
import TI.Timer;
import application.Menu.MenuAction;
import hardware.additional.Button;

public class ButtonTest implements MenuAction {
    @Override
    public String getName() {
        return "Test de button";
    }

    @Override
    public void action() {
        Button button = new Button(0);
        Timer t1 = new Timer(10000);

        while(true) {
            if(button.check()) {
                System.out.println("De Knop is niet ingedruckt\n");
            } else {
                System.out.println("De knop is ingedrukt\n");
            }
            BoeBot.wait(500);
        }
    }
}
