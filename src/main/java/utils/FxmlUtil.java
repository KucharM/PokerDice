package utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class FxmlUtil {

    public static Pane loadWindow(String fxmlPath) {
        FXMLLoader fxmlLoader = new FXMLLoader(FxmlUtil.class.getClass().getResource(fxmlPath));
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
