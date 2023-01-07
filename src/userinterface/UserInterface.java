package userinterface;

import TI.BoeBot;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class UserInterface extends Application {
    private ArrayList<String> tableCoords = new ArrayList<String>();
    private ArrayList<CheckBox> tableCheckbox = new ArrayList<>();
    private ArrayList<String> kitchenCoords = new ArrayList<>();
    private ArrayList<String> cartCoords = new ArrayList<>();
    private ArrayList<CheckBox> allCheckBoxes = new ArrayList<>();
    private String selection;
//    private UserInterface userInterface = new UserInterface();
    private Navigation bob = new Navigation();

    public UserInterface() {

    }

    public static void main(String[] args) {
        launch(UserInterface.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(550, 350);

        VBox selectTableVBox = new VBox();
        selectTableVBox.setSpacing(15);

        GridPane checkboxGrid = new GridPane();
        GridPane buttonGrid = new GridPane();

        checkboxGrid.setHgap(10);
        checkboxGrid.setVgap(10);

        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);

        MenuBar menuBar = new MenuBar();
        Menu actionMenu = new Menu("Acties");

        menuBar.getMenus().add(actionMenu);

        MenuItem mainMenu = new MenuItem("Hoofdmenu");
        MenuItem selectTable = new MenuItem("Tafel positie");
        MenuItem selectCart = new MenuItem("Kar positie");
        MenuItem selectKitchen = new MenuItem("Keuken positie");

        actionMenu.getItems().addAll(mainMenu, selectTable, selectCart, selectKitchen);

        selectTableVBox.getChildren().add(checkboxGrid);

        makeCheckGridPane(checkboxGrid, 8,6);
        makeGridPane(buttonGrid, 8, 6);

        Label welcome = new Label("Welkom!");

        borderPane.setTop(menuBar);
        borderPane.setCenter(welcome);

        mainMenu.setOnAction(e -> {
            mainMenu.setDisable(true);
            selectKitchen.setDisable(false);
            selectCart.setDisable(false);
            selectTable.setDisable(false);
            System.out.println("Hoofdmenu");
            borderPane.setCenter(buttonGrid);
        });

        selectTable.setOnAction(e -> {
            System.out.println("Selecteer tafel");
            this.selection = "table";
            clearCheckBoxes();
//            for (CheckBox coords : this.tableCheckbox) {
//                if(coords.isSelected()) {
//
//                }
//            }
            mainMenu.setDisable(false);
            selectKitchen.setDisable(false);
            selectCart.setDisable(false);
            selectTable.setDisable(true);

            borderPane.setCenter(checkboxGrid);
        });

        selectCart.setOnAction(e -> {
            System.out.println("Selecteer kar");
            this.selection = "cart";
            clearCheckBoxes();
            mainMenu.setDisable(false);
            selectKitchen.setDisable(false);
            selectCart.setDisable(true);
            selectTable.setDisable(false);

            borderPane.setCenter(checkboxGrid);
        });

        selectKitchen.setOnAction(e -> {
            System.out.println("Selecteer keuken");
            this.selection = "kitchen";
            clearCheckBoxes();
            mainMenu.setDisable(false);
            selectKitchen.setDisable(true);
            selectCart.setDisable(false);
            selectTable.setDisable(false);

            borderPane.setCenter(checkboxGrid);
        });

        Scene Scene = new Scene(borderPane);

        primaryStage.setScene(Scene);
        primaryStage.setTitle("BoeBot GUI :)");
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    private ArrayList<String> makeCheckGridPane(GridPane gridPane, int x, int y){
        for (int i = 0; i < y; i++)
        {
            for (int j = 0; j < x; j++)
            {
                CheckBox checkBox = new CheckBox(j + ", " + i);
                checkBox.setMaxSize(50, 50);

                checkBox.getProperties().put('x', j);
                checkBox.getProperties().put('y', i);
                allCheckBoxes.add(checkBox);

                Button submit = new Button("Submit");
                gridPane.add(submit, x-x, y+1);
                submit.setOnAction(e -> {
                    if(this.selection.equals("table")) {
                        this.tableCoords.clear();
                        for(CheckBox checkBox1 : allCheckBoxes) {
                            if(checkBox1.isSelected()) {
                                int xCoord = (int)checkBox1.getProperties().get('x');
                                int yCoord = (int)checkBox1.getProperties().get('y');
                                this.tableCoords.add(xCoord + "," + yCoord);
                                this.tableCheckbox.add(checkBox1);
                            }
                        }
                    }
                    if(this.selection.equals("cart")) {
                        this.cartCoords.clear();
                        for(CheckBox checkBox1 : allCheckBoxes) {
                            if(checkBox1.isSelected()) {
                                int xCoord = (int)checkBox1.getProperties().get('x');
                                int yCoord = (int)checkBox1.getProperties().get('y');
                                this.cartCoords.add(xCoord + "" + yCoord);
                            }
                        }
                    }
                    if(this.selection.equals("kitchen")) {
                        this.kitchenCoords.clear();
                        for(CheckBox checkBox1 : allCheckBoxes) {
                            if(checkBox1.isSelected()) {
                                int xCoord = (int)checkBox1.getProperties().get('x');
                                int yCoord = (int)checkBox1.getProperties().get('y');
                                this.kitchenCoords.add(xCoord + "" + yCoord);
                            }
                        }
                    }
                    System.out.println(this.tableCoords);
                    System.out.println(this.cartCoords);
                    System.out.println(this.kitchenCoords);
                });
                gridPane.add(checkBox, j, i);
                allCheckBoxes.add(checkBox);
            }
        }
        bob.copyTableCoords(this.tableCoords);
        return tableCoords;
    }

        private void makeGridPane(GridPane gridPane, int x, int y){
        ArrayList<Button> btnList = new ArrayList<>();

        for (int i = 0; i < y; i++)
        {
            for (int j = 0; j < x; j++)
            {
                Button button = new Button(j + ", " + i );
                button.setMaxSize(50, 50);

                button.getProperties().put('x', j);
                button.getProperties().put('y', i);
                button.setOnAction(e -> {
                    Button b = (Button) e.getSource();
                    int xb = (int) b.getProperties().get('x');
                    int yb = (int) b.getProperties().get('y');
                    bob.calculate(xb, yb, false);
                    System.out.printf("%d, %d\n", xb, yb);

                });
                gridPane.add(button, j, i);
                btnList.add(button);
            }
        }
    }

    public void clearCheckBoxes() {
        for(CheckBox checkBox : this.allCheckBoxes) {
            checkBox.setSelected(false);
        }
    }

    public ArrayList<String> getTableCoords() {
        return tableCoords;
    }
}

