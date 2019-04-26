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
        quitGame.setHeaderText("Are you sure you want to quit this game?");
        Optional<ButtonType> result = quitGame.showAndWait();
        return result;
    }

    public static void dialogUserWin() {
        Alert userWins = new Alert(Alert.AlertType.INFORMATION);
        userWins.setTitle("");
        userWins.setHeaderText("YOU WIN!");
        userWins.show();
    }

    public static void dialogCpuWin() {
        Alert userWins = new Alert(Alert.AlertType.INFORMATION);
        userWins.setTitle("");
        userWins.setHeaderText("Cpu WIN!");
        userWins.show();
    }

    public static void dialogDraw() {
        Alert draw = new Alert(Alert.AlertType.INFORMATION);
        draw.setTitle("");
        draw.setHeaderText("DRAW");
        draw.show();
    }
}
