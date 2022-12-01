package application.Menu.MenuActions;

import application.Menu.MenuAction;

public class IDKeentest implements MenuAction {
    @Override
    public String getName() {
        return "werkt ig";
    }

    @Override
    public void action() {
        System.out.println("Koele shit");
    }
}
