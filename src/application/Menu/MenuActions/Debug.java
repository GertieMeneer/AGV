package application.Menu.MenuActions;

import application.Menu.MenuAction;

public class Debug implements MenuAction {

    @Override
    public String getName() {
        return "Print something";
    }

    @Override
    public void action() {
        System.out.println("it works!");
    }
}
