package userinterface;

import TI.BoeBot;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class UserInterface extends Application {

    public static void main(String[] args) {
        launch(UserInterface.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ArrayList<String> tableCoordinates = new ArrayList<>();
        ArrayList<String> cartCoordinates = new ArrayList<>();

        //default view
        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(400, 300);

        VBox selectTableVBox = new VBox();
        selectTableVBox.setSpacing(15);

        GridPane tableGrid = new GridPane();
        tableGrid.setHgap(10);
        tableGrid.setVgap(10);

        MenuBar menuBar = new MenuBar();
        Menu actionMenu = new Menu("Acties");

        menuBar.getMenus().addAll(actionMenu);

        MenuItem selectTable = new MenuItem("Tafel positie");
        MenuItem selectRoute = new MenuItem("Selecteer route");
        MenuItem selectCart = new MenuItem("Kar positie");
        MenuItem selectKitchen = new MenuItem("Keuken positie");

        actionMenu.getItems().addAll(selectTable, selectRoute, selectCart, selectKitchen);

        selectTableVBox.getChildren().addAll(new Label("Tafel positie"));
        selectTableVBox.getChildren().add(tableGrid);

        tableCoordinates = makeCheckGridPane(tableGrid, 8,6);

        Label welcome = new Label("Welkom!");

        borderPane.setTop(menuBar);
        borderPane.setCenter(welcome);

        selectTable.setOnAction(e -> {
            System.out.println("Selecteer tafel");

            selectKitchen.setDisable(false);
            selectCart.setDisable(false);
            selectRoute.setDisable(false);
            selectTable.setDisable(true);

            borderPane.setCenter(tableGrid);
        });

        selectRoute.setOnAction(e -> {
            System.out.println("Selecteer route");

            selectKitchen.setDisable(false);
            selectCart.setDisable(false);
            selectRoute.setDisable(true);
            selectTable.setDisable(false);

//            borderPane.setCenter();
        });

        selectCart.setOnAction(e -> {
            System.out.println("Selecteer kar");

            selectKitchen.setDisable(false);
            selectCart.setDisable(true);
            selectRoute.setDisable(false);
            selectTable.setDisable(false);

//            borderPane.setCenter();
        });

        selectKitchen.setOnAction(e -> {
            System.out.println("Selecteer keuken");

            selectKitchen.setDisable(true);
            selectCart.setDisable(false);
            selectRoute.setDisable(false);
            selectTable.setDisable(false);

//            borderPane.setCenter();
        });

        Scene Scene = new Scene(borderPane);

        primaryStage.setScene(Scene);
        primaryStage.show();
    }



    private ArrayList<String> makeCheckGridPane(GridPane gridPane, int x, int y){
        ArrayList<CheckBox> allCheckBoxes = new ArrayList<>();
        ArrayList<String> tableCoords = new ArrayList<>();

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
                    tableCoords.clear();
                    for(CheckBox checkBox1 : allCheckBoxes) {
                        if(checkBox1.isSelected()) {
                            int xCoord = (int)checkBox1.getProperties().get('x');
                            int yCoord = (int)checkBox1.getProperties().get('y');
                            tableCoords.add(xCoord + "" + yCoord);
                        }
                    }
                    System.out.println(tableCoords);
//                    CheckBox c = (CheckBox) e.getSource();
//                    int xb = (int) c.getProperties().get('x');
//                    int yb = (int) c.getProperties().get('y');
//                    System.out.printf("%d, %d\n", xb, yb);
                });
                gridPane.add(checkBox, j, i);
                allCheckBoxes.add(checkBox);
            }
        }
        return tableCoords;
    }

    //    private ArrayList<Button> makeGridPane(GridPane gridPane, int x, int y){
//        ArrayList<Button> btnList = new ArrayList<>();
//
//        for (int i = 0; i < y; i++)
//        {
//            for (int j = 0; j < x; j++)
//            {
//                Button button = new Button(j + ", " + i );
//                button.setMaxSize(50, 50);
//
//                button.getProperties().put('x', j);
//                button.getProperties().put('y', i);
//                button.setOnAction(e -> {
//                    Button b = (Button) e.getSource();
//                    int xb = (int) b.getProperties().get('x');
//                    int yb = (int) b.getProperties().get('y');
//                    System.out.printf("%d, %d\n", xb, yb);
//
//                });
//                gridPane.add(button, j, i);
//                btnList.add(button);
//            }
//        }
//        return btnList;
//    }

    public void printCoords(ArrayList<String> coords) {
        System.out.println(coords);
    }
}
