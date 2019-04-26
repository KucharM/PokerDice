package utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class WindowLoader {

    public static Pane loadWindow(String fxmlPath) {
        FXMLLoader fxmlLoader = new FXMLLoader(WindowLoader.class.getClass().getResource(fxmlPath));
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
