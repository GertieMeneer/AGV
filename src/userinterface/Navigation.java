package userinterface;

import java.util.ArrayList;

public class Navigation {

    private int boebotX = 0;
    private int boebotY = 0;
    private int destinationRotation = 0;
    private int boebotRotation = 0;

    private ArrayList<String> blockades;
    private int topBorder = 5;
    private int rightBorder = 7;

    private int navigationX;
    private int navigationY;
    private boolean negativeX;
    private boolean negativeY;
    int currentX;
    int currentY;
    private String route = "";
    private UserInterface ui;
    private BoeBotConnection boeBotConnection = new BoeBotConnection();

    public Navigation() {
        this.blockades = new ArrayList<>();
    }

    public void copyTableCoords(ArrayList arrayList) {
        this.blockades = arrayList;
    }

    public String calculate(int destinationX, int destinationY, boolean useRotation) {
        boolean navigating = true;
        route = "";
        System.out.println("blockades:");
        System.out.println(this.blockades);
        currentY = boebotY;
        currentX = boebotX;

//      first i calulate the distances of the route, this will be used to calculate the rest.
        navigationY = destinationY - boebotY;
        navigationX = destinationX - boebotX;

        while (navigating == true) {
//          before i start the calculation i look in what direction the destination is by looking if it's negative,
//          i then use a boolean to remember that. i then make the integer positive to keep the program working.
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

//            here begins the actual calculation of where the robot has to go.
//            simply said this algorithm tries to drive in two straight lines unless there is something blocking it's way.

            for (int i = 0; i < navigationY; i++) {
                if (negativeY == true) {
                    char test = driveDown();
                    if (test != 'W') {
                        i--;
                    }
//                  if there is something blocking the way it goes through all it's movement options until it's possible
                    if (test == 'o') {
                        test = driveLeft();
                        while (test == 'o'){
                            test = driveUp();
                            while (test == 'o'){
                                test = driveRight();
                                route += test;
                                test = driveUp();
                            }
                            route += test;
                            test = driveLeft();
                        }
                        route += test;
                        if (test != 'W') {
                            test = driveLeft();
                            route += test;
                            navigationX--;
                        }

                    } else {
                        route += test;
                    }
                    route += test;
                } else {
                    char test = driveUp();
                    if (test != 'W') {
                        i--;
                    }
//                  if there is something blocking the way it goes through all it's movement options until it's possible
                    if (test == 'o') {
                        test = driveRight();
                        while (test == 'o'){
                            test = driveDown();
                            while (test == 'o'){
                                test = driveLeft();
                                route += test;
                                test = driveDown();
                            }
                            route += test;
                            test = driveRight();
                        }
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
//                    if there is something blocking the way it goes through all it's movement options until it's possible
                    if (test == 'o') {
                        test = driveUp();
                        while (test == 'o'){
                            test = driveRight();
                            while (test == 'o'){
                                test = driveDown();
                                route += test;
                                test = driveRight();
                            }
                            route += test;

                            test = driveUp();
                        }
                        route += test;
                        if (test != 'W') {
                            test = driveUp();
                            route += test;
                        }
                    } else {
                        route += test;
                    }
                } else {
                    char test = driveRight();
                    if (test != 'W') {
                        i--;
                    }
//                    if there is something blocking the way it goes through all it's movement options until it's possible
                    if (test == 'o') {
                        test = driveDown();
                        while (test == 'o'){
                            test = driveLeft();
                            while (test == 'o'){
                                test = driveUp();
                                route += test;
                                test = driveLeft();
                            }
                            route += test;
                            test = driveDown();
                        }
                        route += test;
                        if (test != 'W') {
                            test = driveDown();
                            route += test;
                        }
                    } else {
                        route += test;
                    }
                }


            }
//            when the program has gone through both it's x and y commands it checks if it's arrived
//            and if not it recalculates from it's current position to get to the final destination.
            if (destinationX == currentX && destinationY == currentY) {
                navigating = false;
            } else{
                navigationY = destinationY - currentY;
                navigationX = destinationX - currentX;
            }
        }

//        lastly if the user put in a rotation he wanted the robot to be in at the end, then this last if-statement checks if
//        that rotation is correct and rotates the robot to the correct rotation if not.
        if (boebotRotation != destinationRotation && useRotation == true) {
            if (boebotRotation + 1 == destinationRotation || (boebotRotation == 3 && destinationRotation == 0)) {
                route += 'D';
            } else if (boebotRotation + 1 == destinationRotation || (boebotRotation == 0 && destinationRotation == 3)) {
                route += 'A';
            } else {
                route += 'S';
            }
            boebotRotation = destinationRotation;
        }
        System.out.println(route);
        boeBotConnection.sendRoute(route);
        boebotX = currentX;
        boebotY = currentY;
        return route;
    }

//    the turn functions are simple and merely used to always update the rotation and send the correct character.

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
                if (boebotRotation == -1){
                    boebotRotation = 3;
                }else {
                    boebotRotation = 2;
                }
            }
        }
        return 'S';
    }

//    the drive methods are used give back the right characters to drive in the given direction, though you have to keep in mind
//    that they can only give one character at a time and need to be called twice to move actually move in that direction.

    private char driveRight() {
//        first this method checks for blockades or the border of the grid and returns an 'o' to tell the calculation to "reroute".
//        if no blockades are found it checks what rotation the robot is in (during the calculation) to turn towards the right direction.
//        if the rotation is correct it drives forward
        if ((blockades.contains((currentX + 1) + "," + (currentY + 1)) && blockades.contains((currentX + 1) + "," + (currentY))) || currentX > rightBorder || currentY > topBorder) {
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
//        first this method checks for blockades or the border of the grid and returns an 'o' to tell the calculation to "reroute".
//        if no blockades are found it checks what rotation the robot is in (during the calculation) to turn towards the right direction.
//        if the rotation is correct it drives forward
        if ((blockades.contains((currentX) + "," + (currentY + 1)) && blockades.contains((currentX) + "," + (currentY))) || currentX < 0 || currentY < 0) {
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
//        first this method checks for blockades or the border of the grid and returns an 'o' to tell the calculation to "reroute".
//        if no blockades are found it checks what rotation the robot is in (during the calculation) to turn towards the right direction.
//        if the rotation is correct it drives forward
        if ((blockades.contains((currentX) + "," + (currentY)) && blockades.contains((currentX + 1) + "," + (currentY))) || currentX < 0 || currentY < 0) {
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
//        first this method checks for blockades or the border of the grid and returns an 'o' to tell the calculation to "reroute".
//        if no blockades are found it checks what rotation the robot is in (during the calculation) to turn towards the right direction.
//        if the rotation is correct it drives forward
        if ((blockades.contains((currentX) + "," + (currentY + 1)) && blockades.contains((currentX + 1) + "," + (currentY + 1))) || currentX > rightBorder || currentY > topBorder) {
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
        String coords = boebotX + "," + boebotY;
        return coords;
    }

    public void sendRoute() {

    }
}
