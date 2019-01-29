package dialog;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Dialogs {

    public static void dialogAboutApp() {
        Alert aboutApp = new Alert(Alert.AlertType.INFORMATION);
        aboutApp.setTitle("About Poker Dice");
        aboutApp.setHeaderText("header");
        aboutApp.setContentText("content text");
        aboutApp.showAndWait();
    }

    public static Optional<ButtonType> dialogExitApp() {
        Alert extiApp = new Alert(Alert.AlertType.CONFIRMATION);
        extiApp.setTitle("Confirm Exit");
        extiApp.setHeaderText("Are you sure you want to exit PokerDice?");
        Optional<ButtonType> result = extiApp.showAndWait();
        return result;
    }

    public static Optional<ButtonType> dialogQuitGame() {
        Alert quitGame = new Alert(Alert.AlertType.CONFIRMATION);
        quitGame.setTitle("Confirm Quit");
        quitGame.setHeaderText("Are you sure you want to quit this game");
        Optional<ButtonType> result = quitGame.showAndWait();
        return result;
    }
}
