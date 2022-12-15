package userinterface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class UserInterface extends Application {
    public static void main(String[] args) {
        launch(UserInterface.class);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox();
        GridPane gridPane = new GridPane();

        gridPane.setHgap(10);
        gridPane.setVgap(10);

        vBox.setSpacing(15);

        Menu actionMenu = new Menu("Acties");
        MenuBar menuBar = new MenuBar();

        menuBar.getMenus().addAll(actionMenu);

        MenuItem selectTable = new MenuItem("Tafel positie");
        MenuItem selectRoute = new MenuItem("Selecteer route");
        MenuItem selectCart = new MenuItem("Kar positie");

        actionMenu.getItems().addAll(selectTable, selectRoute, selectCart);

        selectTable.setOnAction(e -> {
            System.out.println("Selecteer tafel");
        });

        selectRoute.setOnAction(e -> {
            System.out.println("Selecteer route");
        });

        selectCart.setOnAction(e -> {
            System.out.println("Selecteer kar");
        });

        vBox.getChildren().add(menuBar);

        vBox.getChildren().addAll(new Label("Tafel positie"));

        ArrayList<Button> naam = makeGridPane(gridPane, 8,6);

        vBox.getChildren().add(gridPane);

        Scene tabelPositionScene = new Scene(vBox);

        primaryStage.setScene(tabelPositionScene);
        primaryStage.show();
    }

    private ArrayList<Button> makeGridPane(GridPane gridPane, int x, int y){
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
                    System.out.printf("%d, %d\n", xb, yb);

                });

                gridPane.add(button, j, i);
                btnList.add(button);
            }
        }

        return btnList;
    }
}
