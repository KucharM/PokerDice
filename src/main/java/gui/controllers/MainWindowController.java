package gui.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainWindowController {
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
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/GameWindow.fxml"));
        Pane pane = null;
        try {
            pane = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainWindow.setCenter(pane);
    }

    public void quitGame() {
        this.initialize();
    }

    public void exit() {
        Platform.exit();
        System.exit(0);
    }
}
