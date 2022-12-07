package application.Menu.MenuActions.DebugActions;

import TI.Timer;
import application.Menu.Menu;
import application.Menu.MenuAction;
import hardware.servos.GrabbingCrane;
import hardware.servos.Wheel;
import interfacing.Drive;

import java.util.Scanner;

public class ServoDebug implements MenuAction{

    private Scanner scanner;
    private Menu menu;
    private String name;

    public ServoDebug(Scanner scanner, Menu menu, String name) {
        this.scanner = scanner;
        this.menu = menu;
        this.name = name;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void action() {
        this.menu.show(scanner);
    }
}
