package userinterface;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UserInterface extends Application {
    public static void main(String[] args) {
        launch(UserInterface.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = new GridPane();

        borderPane.setCenter(gridPane);

//        Button button1 = new Button("Button 1");
//        Button button2 = new Button("Button 1");
//        Button button3 = new Button("Button 1");
//        Button button4 = new Button("Button 1");
//        Button button5 = new Button("Button 1");
//        Button button6 = new Button("Button 1");
//        Button button7 = new Button("Button 1");
//        Button button8 = new Button("Button 1");
//        Button button9 = new Button("Button 1");
//        Button button10 = new Button("Button 1");
//        Button button11 = new Button("Button 1");
//        Button button12 = new Button("Button 1");
//        Button button13 = new Button("Button 1");
//        Button button14 = new Button("Button 1");
//        Button button15 = new Button("Button 1");
//        Button button16 = new Button("Button 1");
//        Button button17 = new Button("Button 1");
//        Button button18 = new Button("Button 1");
//        Button button19 = new Button("Button 1");
//        Button button20 = new Button("Button 1");
//        Button button21 = new Button("Button 1");
//        Button button22 = new Button("Button 1");
//        Button button23 = new Button("Button 1");
//        Button button24 = new Button("Button 1");
//        Button button25 = new Button("Button 1");
//        Button button26 = new Button("Button 1");
//        Button button27 = new Button("Button 1");
//        Button button28 = new Button("Button 1");
//        Button button29 = new Button("Button 1");
//        Button button30 = new Button("Button 1");
//        Button button31 = new Button("Button 1");
//        Button button32 = new Button("Button 1");
//        Button button33 = new Button("Button 1");
//        Button button34 = new Button("Button 1");
//        Button button35 = new Button("Button 1");
//        Button button36 = new Button("Button 1");
//        Button button37 = new Button("Button 1");
//        Button button38 = new Button("Button 1");
//        Button button39 = new Button("Button 1");
//        Button button40 = new Button("Button 1");
//        Button button41 = new Button("Button 1");
//        Button button42 = new Button("Button 1");
//        Button button43 = new Button("Button 1");
//        Button button44 = new Button("Button 1");
//        Button button45 = new Button("Button 1");
//        Button button46 = new Button("Button 1");
//        Button button47 = new Button("Button 1");
//        Button button48 = new Button("Button 1");
//
//        gridPane.getChildren().add(button1);
//
//
//        gridPane.getChildren().addAll(button1, button2, button3, button4, button5,
//                button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19, button20,
//                button21, button22, button23, button24, button25, button26, button27, button28, button29, button30,
//                button31, button32, button33, button34, button35, button36, button37, button38, button39, button40, button41, button42, button43, button44,
//                button45, button46, button47, button48);

        gridPane.setHgap(10);
        gridPane.setVgap(10);


        Menu menu = new Menu();

        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
