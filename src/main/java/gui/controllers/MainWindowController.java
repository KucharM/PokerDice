package gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;

public class MainWindowController {
    private static final String MENU_WINDOW = "/fxml/MainMenuWindow.fxml";
    private Image background = new Image("/dices-img/green-table-jpg.jpg");

    private MainMenuWindowController mainMenuWindowController;

    @FXML
    private Pane mainWindow;

    @FXML
    public void initialize() {
        loadMenuWindow();
    }

    public void loadMenuWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource(MENU_WINDOW));
        Pane pane = null;
        try {
            pane = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mainMenuWindowController = fxmlLoader.getController();
        mainMenuWindowController.setMainWindowController(this);
        setWindow(pane);
    }

    public void start() {
        mainMenuWindowController.startGame();
    }

    public void setWindow(Pane pane) {
        mainWindow.getChildren().clear();
        mainWindow.getChildren().add(pane);
    }
}