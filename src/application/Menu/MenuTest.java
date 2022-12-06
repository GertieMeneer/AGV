package application.Menu;

import application.Menu.MenuActions.DebugActions.ButtonActions;
import application.Menu.MenuActions.DebugActions.LedActions;
import application.Menu.MenuActions.DebugActions.ServoActions;
import application.Menu.MenuActions.SubMenuDebug;
import application.Menu.MenuActions.IDKeentest;
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
        menu.add(new IDKeentest());

        return menu;
    }

    public static Menu createDebugMenu(Scanner scnaner) {
        Menu menu = new Menu();
        menu.add(new ServoActions());
        menu.add(new ButtonActions());
        menu.add(new LedActions());

        return menu;
    }
}