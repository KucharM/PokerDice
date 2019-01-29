package run;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.FxmlUtil;

public class PokerDiceGame extends Application {
    private static final String MAIN_WINDOW_FXML = "/fxml/MainWindow.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane borderPane = FxmlUtil.loadWindow(MAIN_WINDOW_FXML);

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Poker Dice");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}