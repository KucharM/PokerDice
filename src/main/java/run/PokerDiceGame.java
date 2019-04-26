package run;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PokerDiceGame extends Application {
    private static final String MAIN_WINDOW = "/fxml/MainWindow.fxml";
    private Image background = new Image("/dices-img/green-table-jpg.jpg");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(MAIN_WINDOW));
        Pane pane = loader.load();

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Poker Dice");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}