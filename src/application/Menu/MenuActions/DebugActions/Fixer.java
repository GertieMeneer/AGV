package application.Menu.MenuActions.DebugActions;

public class Fixer {
    private boolean debugMode;

    public Fixer() {
        this.debugMode = false;
    }

    public boolean debugMode() {
        return debugMode;
    }

    public void turnOn() {
        debugMode = true;
    }
}
