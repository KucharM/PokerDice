package gui.controllers;

import dialog.Dialogs;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Optional;

public class MainMenuWindowController {
    private static final String GAME_WINDOW = "/fxml/GameWindow.fxml";

    private MainWindowController mainWindowController;

    public void startGame() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(GAME_WINDOW));
        Pane pane = null;
        try {
             pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameWindowController gameWindowController = loader.getController();
        gameWindowController.setMainWindowController(mainWindowController);
        mainWindowController.setWindow(pane);
    }

    public void aboutGame() {
        Dialogs.dialogAboutApp();
    }

    public void exit() {
        Optional<ButtonType> result = Dialogs.dialogExitApp();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }
}
