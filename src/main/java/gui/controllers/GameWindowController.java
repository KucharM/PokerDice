package gui.controllers;

import comparators.DiceListComparator;
import dice.CpuLogic;
import dice.Dice;
import dice.ListOfDice;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GameWindowController {
    static int nrOfRoll;
    private int nrUserDiceToRoll, nrCpuDiceToRoll;
    private int chosenDiceIndex = 0;
    private CpuLogic cpuLogic;
    private MainWindowController mainWindowController;
    private MainMenuWindowController mainMenuWindowController;

    @FXML
    private Label labelInfo;
    @FXML
    private Button rollDiceButton;
    @FXML
    private ImageView drawnUserDice1, drawnUserDice2, drawnUserDice3, drawnUserDice4, drawnUserDice5;
    @FXML
    private ImageView drawnCpuDice1, drawnCpuDice2, drawnCpuDice3, drawnCpuDice4, drawnCpuDice5;
    @FXML
    private ImageView chosenUserDice1, chosenUserDice2, chosenUserDice3, chosenUserDice4, chosenUserDice5;
    @FXML
    private ImageView chosenCpuDice1, chosenCpuDice2, chosenCpuDice3, chosenCpuDice4, chosenCpuDice5;

    private List<ImageView> drawnUserDiceImgView = new ArrayList<>();
    private List<ImageView> chosenUserDiceImgView = new ArrayList<>();
    private List<ImageView> drawnCpuDiceImgView = new ArrayList<>();
    private List<ImageView> chosenCpuDiceImgView = new ArrayList<>();

    private List<Dice> drawnUserDiceList = new ArrayList<>();
    private List<Dice> drawnCpuDiceList = new ArrayList<>();
    private List<Dice> chosenUserDiceList = new ArrayList<>();
    private List<Dice> chosenCpuDiceList = new ArrayList<>();

    public void initialize() {
        drawnUserDiceImgView.containsAll(setDrawnUserDicesImgView(drawnUserDiceImgView));
        drawnCpuDiceImgView.containsAll(setDrawnCpuDicesImgView(drawnCpuDiceImgView));
        chosenUserDiceImgView.containsAll(setChosenUserDicesImgView(chosenUserDiceImgView));
        chosenCpuDiceImgView.containsAll(setChosenCpuDicesImgView(chosenCpuDiceImgView));

        nrOfRoll = 2;
        nrUserDiceToRoll = 5;
        nrCpuDiceToRoll = 5;
        cpuLogic = new CpuLogic();
        labelInfo.setText("Click to play  Poker Dice!");
    }

    @FXML
    public void rollDice() {
        nrOfRoll--;

        countRoll();

        //draw dices
        drawnUserDiceList = new ListOfDice().createDiceList(nrUserDiceToRoll);
        drawnCpuDiceList = new ListOfDice().createDiceList(nrCpuDiceToRoll - chosenCpuDiceList.size());

        //show user drawn dices
        showDrawnDice(drawnUserDiceImgView, drawnUserDiceList, nrUserDiceToRoll);

        //show cpu chosen dices
        List<Dice> chosenDices = cpuLogic.cpuAlgorithm(drawnCpuDiceList, chosenCpuDiceList, nrOfRoll);
        showChosenDice(chosenCpuDiceImgView, chosenDices);

        //show cpu drawn dices
        if (drawnCpuDiceList.size() != 0) {
            showDrawnDice(drawnCpuDiceImgView, drawnCpuDiceList, 5 - chosenCpuDiceList.size());
        }

        if (nrOfRoll == 0) {
            for (ImageView imageView : drawnCpuDiceImgView) {
                imageView.setImage(null);
            }
        }

        listChecker();
    }

    private void listChecker() {
        if (chosenUserDiceList.size() == 5 && chosenCpuDiceList.size() == 5) {
            labelInfo.setText("Score Summary: ");
            DiceListComparator diceListComparator = new DiceListComparator(chosenUserDiceList, chosenCpuDiceList);
            diceListComparator.compare();
        }
    }

    public void countRoll() {
        switch (nrOfRoll) {
            case 2:
                labelInfo.setText("Roll dice");
                break;
            case 1:
                labelInfo.setText("Click dice you want to keep");
                break;
            case 0:
                labelInfo.setText("No more moves, complete your hand");
                rollDiceButton.disableProperty().set(true);
                break;
        }
    }

    private void showDrawnDice(List<ImageView> imageViews, List<Dice> listOfDice, int diceToRoll) {
        switch (diceToRoll) {
            case 4:
                imageViews.get(4).imageProperty().set(null);
                break;
            case 3:
                imageViews.get(4).imageProperty().set(null);
                imageViews.get(3).imageProperty().set(null);
                break;
            case 2:
                imageViews.get(4).imageProperty().set(null);
                imageViews.get(3).imageProperty().set(null);
                imageViews.get(2).imageProperty().set(null);
                break;
            case 1:
                imageViews.get(4).imageProperty().set(null);
                imageViews.get(3).imageProperty().set(null);
                imageViews.get(2).imageProperty().set(null);
                imageViews.get(1).imageProperty().set(null);
                break;
        }

        for (int i = 0; i < diceToRoll; i++) {
            imageViews.get(i).setImage(listOfDice.get(i).getDiceImage());
        }
    }

    private void showChosenDice(List<ImageView> imageViewList, List<Dice> diceList) {
        for (int i = 0; i < diceList.size(); i++) {
            imageViewList.get(i).setImage(diceList.get(i).getDiceImage());
        }
    }

    @FXML
    private void selectDice1() {
        chosenUserDiceList.add(drawnUserDiceList.get(0));
        drawnUserDice1.imageProperty().set(null);
        chosenUserDiceImgView.get(chosenDiceIndex).setImage(chosenUserDiceList.get(chosenDiceIndex).getDiceImage());
        chosenDiceIndex++;
        nrUserDiceToRoll--;
        listChecker();
    }

    @FXML
    private void selectDice2() {
        chosenUserDiceList.add(drawnUserDiceList.get(1));
        drawnUserDice2.imageProperty().set(null);
        chosenUserDiceImgView.get(chosenDiceIndex).setImage(chosenUserDiceList.get(chosenDiceIndex).getDiceImage());
        chosenDiceIndex++;
        nrUserDiceToRoll--;
        listChecker();
    }

    @FXML
    private void selectDice3() {
        chosenUserDiceList.add(drawnUserDiceList.get(2));
        drawnUserDice3.imageProperty().set(null);
        chosenUserDiceImgView.get(chosenDiceIndex).setImage(chosenUserDiceList.get(chosenDiceIndex).getDiceImage());
        chosenDiceIndex++;
        nrUserDiceToRoll--;
        listChecker();
    }

    @FXML
    private void selectDice4() {
        chosenUserDiceList.add(drawnUserDiceList.get(3));
        drawnUserDice4.imageProperty().set(null);
        chosenUserDiceImgView.get(chosenDiceIndex).setImage(chosenUserDiceList.get(chosenDiceIndex).getDiceImage());
        chosenDiceIndex++;
        nrUserDiceToRoll--;
        listChecker();
    }

    @FXML
    private void selectDice5() {
        chosenUserDiceList.add(drawnUserDiceList.get(4));
        drawnUserDice5.imageProperty().set(null);
        chosenUserDiceImgView.get(chosenDiceIndex).setImage(chosenUserDiceList.get(chosenDiceIndex).getDiceImage());
        chosenDiceIndex++;
        nrUserDiceToRoll--;
        listChecker();
    }

    private List<ImageView> setDrawnUserDicesImgView(List<ImageView> userDrawnDicesImgView) {
        userDrawnDicesImgView.add(drawnUserDice1);
        userDrawnDicesImgView.add(drawnUserDice2);
        userDrawnDicesImgView.add(drawnUserDice3);
        userDrawnDicesImgView.add(drawnUserDice4);
        userDrawnDicesImgView.add(drawnUserDice5);
        return userDrawnDicesImgView;
    }

    private List<ImageView> setDrawnCpuDicesImgView(List<ImageView> drawnCpuDicesImgView) {
        drawnCpuDicesImgView.add(drawnCpuDice1);
        drawnCpuDicesImgView.add(drawnCpuDice2);
        drawnCpuDicesImgView.add(drawnCpuDice3);
        drawnCpuDicesImgView.add(drawnCpuDice4);
        drawnCpuDicesImgView.add(drawnCpuDice5);
        return drawnCpuDicesImgView;
    }

    private List<ImageView> setChosenUserDicesImgView(List<ImageView> chosenUserDiceImgView) {
        chosenUserDiceImgView.add(chosenUserDice1);
        chosenUserDiceImgView.add(chosenUserDice2);
        chosenUserDiceImgView.add(chosenUserDice3);
        chosenUserDiceImgView.add(chosenUserDice4);
        chosenUserDiceImgView.add(chosenUserDice5);
        return chosenUserDiceImgView;
    }

    private List<ImageView> setChosenCpuDicesImgView(List<ImageView> chosenCpuDiceImgView) {
        chosenCpuDiceImgView.add(chosenCpuDice1);
        chosenCpuDiceImgView.add(chosenCpuDice2);
        chosenCpuDiceImgView.add(chosenCpuDice3);
        chosenCpuDiceImgView.add(chosenCpuDice4);
        chosenCpuDiceImgView.add(chosenCpuDice5);
        return chosenCpuDiceImgView;
    }

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    public void setMainMenuWindowController(MainMenuWindowController mainMenuWindowController) {
        this.mainMenuWindowController = mainMenuWindowController;
    }

    public void backToMenu() {
            mainWindowController.loadMenuWindow();
    }

    public void newGame() {
        mainWindowController.start();
    }
}