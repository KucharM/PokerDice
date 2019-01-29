package gui.controllers;

import dialog.Dialogs;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import utils.FxmlUtil;

import java.io.IOException;
import java.util.Optional;

public class MainWindowController {
    private static final String GAME_WINDOW_FXML = "/fxml/GameWindow.fxml";
    @FXML
    private BorderPane mainWindow;

    @FXML
    public void initialize() {

        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/MainMenuWindow.fxml"));
        HBox hBox = null;
        try {
            hBox = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MainMenuWindowController mainMenuWindowController = fxmlLoader.getController();
        mainMenuWindowController.setMainWindowController(this);
        mainWindow.setCenter(hBox);
    }

    public void startNewGame() {
        Pane pane = FxmlUtil.loadWindow(GAME_WINDOW_FXML);
        mainWindow.setCenter(pane);
    }

    public void quitGame() {
        Optional<ButtonType> result = Dialogs.dialogQuitGame();
        if (result.get() == ButtonType.OK)
            this.initialize();
    }

    public void exit() {
        Optional<ButtonType> result = Dialogs.dialogExitApp();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }

    public void showAboutApp() {
        Dialogs.dialogAboutApp();
    }
}
