package application.Menu;

import application.Menu.MenuActions.DebugActions.DebugServoActions.ButtonTest;
import application.Menu.MenuActions.DebugActions.DebugServoActions.DriveTest;
import application.Menu.MenuActions.DebugActions.DebugServoActions.GrabbingTest;
import application.Menu.MenuActions.DebugActions.LedDebug;
import application.Menu.MenuActions.DebugActions.ServoDebug;
import application.Menu.MenuActions.FinalCode;
import application.Menu.MenuActions.SubMenuDebug;

import java.util.Scanner;

public class MenuTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu mainMenu = createMenu(scanner);
        mainMenu.show(scanner);
    }

    public static Menu createMenu(Scanner scanner) {
        Menu menu = new Menu();

        menu.add(new SubMenuDebug(scanner, createDebugMenu(scanner), "Debug menu"));
        menu.add(new FinalCode());

        return menu;
    }

    public static Menu createDebugMenu(Scanner scanner) {
        Menu menu = new Menu();

        menu.add(new ServoDebug(scanner, createServoMenu(), "Servo menu"));
        menu.add(new ButtonTest());
        menu.add(new LedDebug());

        return menu;
    }

    public static Menu createServoMenu() {
        Menu menu = new Menu();

        menu.add(new DriveTest());
        menu.add(new GrabbingTest());

        return menu;
    }

}