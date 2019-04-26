package gui.controllers;


public class AboutWindowController {
    private MainWindowController mainWindowController;

    public void backToMenu() {
        mainWindowController.loadMenuWindow();
    }

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }
}
