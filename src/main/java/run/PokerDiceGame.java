package run;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PokerDiceGame extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/MainWindow.fxml"));
        BorderPane borderPane = fxmlLoader.load();

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Poker Dice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
