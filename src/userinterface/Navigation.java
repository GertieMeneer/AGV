package userinterface;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Navigation {

    private int boebotX = 0;
    private int boebotY = 0;
    private int destinationRotation = 0;
    private int boebotRotation = 0;


    private ArrayList<String> blockades;

    private int navigationX;
    private int navigationY;
    private boolean negativeX;
    private boolean negativeY;
    int currentX;
    int currentY;
    private String route = "";


    public Navigation() {

    }

    public String calculate(int destinationX, int destinationY, boolean useRotation) {
        UserInterface ui = new UserInterface();
        boolean navigating = true;
        route = "";
        this.blockades = ui.getTableCoords();
        currentY = boebotY;
        currentX = boebotX;

        navigationY = destinationY - boebotY;
        navigationX = destinationX - boebotX;

        while (navigating == true) {
            if (navigationY < 0) {
                navigationY *= -1;
                negativeY = true;
            } else {
                negativeY = false;
            }
            if (navigationX < 0) {
                navigationX *= -1;
                negativeX = true;
            } else {
                negativeX = false;
            }

            for (int i = 0; i < navigationY; i++) {
                if (negativeY == true) {
                    char test = driveDown();
                    if (test != 'W') {
                        i--;
                    }
                    if (test == 'o') {
                        test = driveRight();
                        route += test;
                        if (test != 'W') {
                            test = driveRight();
                            route += test;
                        }
                        navigationX--;
                    } else {
                        route += test;
                    }
                    route += test;
                } else {
                    char test = driveUp();
                    if (test != 'W') {
                        i--;
                    }
                    if (test == 'o') {
                        test = driveRight();
                        route += test;
                        if (test != 'W') {
                            test = driveRight();
                            route += test;
                        }
                        navigationX--;
                    } else {
                        route += test;
                    }

                }
            }

            for (int i = 0; i < navigationX; i++) {
                if (negativeX == true) {
                    char test = driveLeft();
                    if (test != 'W') {
                        i--;
                    }
                    if (test == 'o') {
                        test = driveUp();
                        route += test;
                        if (test != 'W') {
                            test = driveUp();
                            route += test;
                        }
//                        navigationY++;
                    } else {
                        route += test;
                    }
                } else {
                    char test = driveRight();
                    if (test != 'W') {
                        i--;
                    }
                    if (test == 'o') {
                        test = driveDown();
                        route += test;
                        if (test != 'W') {
                            test = driveDown();
                            route += test;
                        }
//                        navigationY--;
                    } else {
                        route += test;
                    }
                }


            }

            if (destinationX == currentX && destinationY == currentY) {
                navigating = false;
            } else{
                navigationY = destinationY - currentY;
                navigationX = destinationX - currentX;
            }
        }

        if (boebotRotation != destinationRotation && useRotation == true) {
            if (boebotRotation + 1 == destinationRotation || (boebotRotation == 3 && destinationRotation == 0)) {
                route += 'D';
            } else if (boebotRotation + 1 == destinationRotation || (boebotRotation == 0 && destinationRotation == 3)) {
                route += 'A';
            } else {
                route += 'S';
            }

        }
        System.out.println(route);
        return route;
    }

    private char turnLeft() {

        boebotRotation--;
        if (boebotRotation < 0) {
            boebotRotation = 3;
        }
        return 'A';
    }

    private char turnRight() {

        boebotRotation++;
        if (boebotRotation > 3) {
            boebotRotation = 0;
        }
        return 'D';
    }

    private char turnAround(){
        for (int j = 0; j < 2; j++) {
            boebotRotation--;
            if (boebotRotation < 0) {
                boebotRotation = 3;
            }
        }
        return 'S';
    }

    private char driveRight() {
        if (blockades.contains((currentX + 1) + "," + (currentY + 1)) && blockades.contains((currentX + 1) + "," + (currentY))) {
            return 'o';
        } else {
            if (boebotRotation == 3) {
                return turnAround();
            } else if (boebotRotation == 0) {
                return turnRight();
            } else if (boebotRotation == 2) {
                return turnLeft();
            } else {
                currentX++;
                return 'W';
            }
        }

    }

    private char driveLeft() {
        if (blockades.contains((currentX) + "," + (currentY + 1)) && blockades.contains((currentX) + "," + (currentY))) {
            return 'o';
        } else {
            if (boebotRotation == 1) {
                return turnAround();

            } else if (boebotRotation == 2) {
                return turnRight();
            } else if (boebotRotation == 0) {
                return turnLeft();
            } else {
                currentX--;
                return 'W';
            }
        }
    }

    private char driveDown() {
        if (blockades.contains((currentX) + "," + (currentY)) && blockades.contains((currentX + 1) + "," + (currentY))) {
            return 'o';

        } else {
            if (boebotRotation == 0) {
                return turnAround();
            } else if (boebotRotation == 1) {
                return turnRight();
            } else if (boebotRotation == 3) {
                return turnLeft();
            } else {
                currentY--;
                return 'W';
            }
        }
    }

    private char driveUp() {
        if (blockades.contains((currentX) + "," + (currentY + 1)) && blockades.contains((currentX + 1) + "," + (currentY + 1))) {
            return 'o';
        } else {
            if (boebotRotation == 2) {
                negativeY = false;
                return turnAround();
            } else if (boebotRotation == 3) {
                return turnRight();
            } else if (boebotRotation == 1) {
                return turnLeft();
            } else {
                currentY++;
                return 'W';
            }
        }
    }

    public void setDestinationRotation(int destinationRotation) {
        this.destinationRotation = destinationRotation;
    }

    private String getBotCoords() {
        //
        return "";
    }
}
