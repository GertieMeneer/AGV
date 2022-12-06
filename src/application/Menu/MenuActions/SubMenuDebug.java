package application.Menu.MenuActions;

import application.Menu.Menu;
import application.Menu.MenuAction;
import java.util.Scanner;

public class SubMenuDebug implements MenuAction {
    private Scanner scanner;
    private Menu debugMenu;
    private String name;

    public SubMenuDebug(Scanner scanner, Menu subMenu, String name) {
        this.scanner = scanner;
        this.debugMenu = subMenu;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void action() {
        this.debugMenu.show(scanner);
    }
}
