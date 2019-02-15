package gui.controllers;

import dice.Dice;
import dice.GameLogic;
import dice.ListOfDice;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class GameWindowController {
    static int nrOfRounds = 3;
    private int nrUserDiceToRoll = 5, nrCpuDiceToRoll = 5;
    private int chosenDiceIndex = 0;
    private GameLogic game = new GameLogic();

    @FXML
    private Label labelInfo;
    @FXML
    private VBox usersSelectedDices, cpuSelectedDice;
    @FXML
    private Button rollDiceButton;
    @FXML
    private ImageView drawnUserDice1, drawnUserDice2, drawnUserDice3, drawnUserDice4, drawnUserDice5;
    private ImageView[] drawnUserDice = {drawnUserDice1, drawnUserDice2, drawnUserDice3, drawnUserDice4, drawnUserDice5};
    @FXML
    private ImageView drawnCpuDice1, drawnCpuDice2, drawnCpuDice3, drawnCpuDice4, drawnCpuDice5;
    private ImageView[] drawnCpuDice = {drawnCpuDice1, drawnCpuDice2, drawnCpuDice3, drawnCpuDice4, drawnCpuDice5};
    @FXML
    private ImageView chosenUserDice1, chosenUserDice2, chosenUserDice3, chosenUserDice4, chosenUserDice5;
    private ImageView[] chosenUserDice = {chosenUserDice1, chosenUserDice2, chosenUserDice3, chosenUserDice4, chosenUserDice5};
    @FXML
    private ImageView chosenCpuDice1, chosenCpuDice2, chosenCpuDice3, chosenCpuDice4, chosenCpuDice5;
    private ImageView[] chosenCpuDice = {chosenCpuDice1, chosenCpuDice2, chosenCpuDice3, chosenCpuDice4, chosenCpuDice5};

    private List<ImageView> drawnUserDiceImgView = new ArrayList<>();
    private List<ImageView> chosenUserDiceImgView = new ArrayList<>();
    private List<ImageView> drawnCpuDiceImgView = new ArrayList<>();
    private List<ImageView> chosenCpuDiceImgView = new ArrayList<>();

    private ListOfDice drawnUserDiceList = game.getUser().getUserDiceList();
    private ListOfDice drawnCpuDiceList = game.getCpuUser().getUserDiceList();
    private List<Dice> chosenUserDiceList = new ArrayList<>();
    private List<Dice> chosenCpuDiceList = new ArrayList<>();

    public void initialize() {
        setDrawnCpuDiceImgView();
        setDrawnUserDiceImgView();
        setChosenUserDiceImgView();
        setChosenCpuDiceImgView();
    }

    @FXML
    public void rollDice() {
        nrOfRounds--;

        drawnUserDiceList.setDiceList(drawnUserDiceList.createDiceList(nrUserDiceToRoll));
        drawnCpuDiceList.setDiceList(drawnCpuDiceList.createDiceList(nrCpuDiceToRoll));

        showDrawnDice(drawnUserDiceImgView, drawnUserDiceList, nrUserDiceToRoll);
        showDrawnDice(drawnCpuDiceImgView, drawnCpuDiceList, nrCpuDiceToRoll);

        switch (nrOfRounds) {
            case 3:
                labelInfo.setText("Roll dice");
                break;
            case 2:
                labelInfo.setText("select dice to re roll");
                break;
            case 1:
                labelInfo.setText("you have one roll");
                break;
            case 0:
                labelInfo.setText("No more moves, complete your hand");
                rollDiceButton.disableProperty().set(true);
                break;
        }
    }

    private void showDrawnDice(List<ImageView> imageViews, ListOfDice listOfDice, int diceToRoll) {
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
            imageViews.get(i).setImage(listOfDice.getDiceImage(i));
        }
    }

    @FXML
    private void selectDice1() {
        chosenUserDiceList.add(drawnUserDiceList.getDice(0));
        drawnUserDice1.imageProperty().set(null);
        chosenUserDiceImgView.get(chosenDiceIndex).setImage(chosenUserDiceList.get(chosenDiceIndex).getDiceImage());
        chosenDiceIndex++;
        nrCpuDiceToRoll--;
    }

    @FXML
    private void selectDice2() {
        chosenUserDiceList.add(drawnUserDiceList.getDice(1));
        drawnUserDice2.imageProperty().set(null);
        chosenUserDiceImgView.get(chosenDiceIndex).setImage(chosenUserDiceList.get(chosenDiceIndex).getDiceImage());
        chosenDiceIndex++;
        nrCpuDiceToRoll--;
    }

    @FXML
    private void selectDice3() {
        chosenUserDiceList.add(drawnUserDiceList.getDice(2));
        drawnUserDice3.imageProperty().set(null);
        chosenUserDiceImgView.get(chosenDiceIndex).setImage(chosenUserDiceList.get(chosenDiceIndex).getDiceImage());
        chosenDiceIndex++;
        nrCpuDiceToRoll--;
    }

    @FXML
    private void selectDice4() {
        chosenUserDiceList.add(drawnUserDiceList.getDice(3));
        drawnUserDice4.imageProperty().set(null);
        chosenUserDiceImgView.get(chosenDiceIndex).setImage(chosenUserDiceList.get(chosenDiceIndex).getDiceImage());
        chosenDiceIndex++;
        nrCpuDiceToRoll--;
    }

    @FXML
    private void selectDice5() {
        chosenUserDiceList.add(drawnUserDiceList.getDice(4));
        drawnUserDice5.imageProperty().set(null);
        chosenUserDiceImgView.get(chosenDiceIndex).setImage(chosenUserDiceList.get(chosenDiceIndex).getDiceImage());
        chosenDiceIndex++;
        nrCpuDiceToRoll--;
    }

    private void setDrawnUserDiceImgView() {
        drawnUserDiceImgView.add(drawnUserDice1);
        drawnUserDiceImgView.add(drawnUserDice2);
        drawnUserDiceImgView.add(drawnUserDice3);
        drawnUserDiceImgView.add(drawnUserDice4);
        drawnUserDiceImgView.add(drawnUserDice5);
    }

    private void setDrawnCpuDiceImgView() {
        drawnCpuDiceImgView.add(drawnCpuDice1);
        drawnCpuDiceImgView.add(drawnCpuDice2);
        drawnCpuDiceImgView.add(drawnCpuDice3);
        drawnCpuDiceImgView.add(drawnCpuDice4);
        drawnCpuDiceImgView.add(drawnCpuDice5);
    }

    private void setChosenUserDiceImgView() {
        chosenUserDiceImgView.add(chosenUserDice1);
        chosenUserDiceImgView.add(chosenUserDice2);
        chosenUserDiceImgView.add(chosenUserDice3);
        chosenUserDiceImgView.add(chosenUserDice4);
        chosenUserDiceImgView.add(chosenUserDice5);
    }

    private void setChosenCpuDiceImgView() {
        chosenCpuDiceImgView.add(chosenCpuDice1);
        chosenCpuDiceImgView.add(chosenCpuDice2);
        chosenCpuDiceImgView.add(chosenCpuDice3);
        chosenCpuDiceImgView.add(chosenCpuDice4);
        chosenCpuDiceImgView.add(chosenCpuDice5);
    }
}