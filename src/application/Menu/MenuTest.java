package application.Menu;

import application.Menu.MenuActions.Debug;
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

        menu.add(new Debug());
        menu.add(new IDKeentest());

        return menu;
    }
}