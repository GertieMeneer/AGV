package application.Menu;

import application.Menu.MenuActions.Debug;
import application.Menu.MenuActions.IDKeentest;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<MenuAction> actions;

    public Menu() {
        this.actions = new ArrayList<>();
    }

    public void add(MenuAction action) {
        this.actions.add(action);
    }

    public void show(Scanner scanner) {

        boolean inMenu = true;

        while (inMenu) {
            System.out.println("\nMenu;");
            for (int i = 0; i < this.actions.size(); i++) {
                MenuAction action = this.actions.get(i);
                System.out.println(i + "\t: " + action.getName());
            }
            System.out.println(this.actions.size() + "\t: Back");

            System.out.print("Make your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == this.actions.size()) {
                inMenu = false;
            } else {
                this.actions.get(choice).action();
            }
        }

    }

}
