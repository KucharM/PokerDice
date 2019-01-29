package gui.controllers;

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
    @FXML
    private VBox usersSelectedDices;
    @FXML
    private Label messageLabel;
    @FXML
    private Button rollDiceButton;
    @FXML
    private Label cpuScore1, cpuScore2, cpuScore3, cpuScore4, cpuScore5, score1, score2, score3, score4, score5, result;
    @FXML
    private ImageView cpuDice1img, cpuDice2img, cpuDice3img, cpuDice4img, cpuDice5img;
    @FXML
    private ImageView userDice1img, userDice2img, userDice3img, userDice4img, userDice5img;
    @FXML
    private ImageView selectedDice1, selectedDice2, selectedDice3, selectedDice4, selectedDice5;

    private List<ImageView> drawnDiceImageView = new ArrayList<>();
    private List<ImageView> chosenDiceImageView = new ArrayList<>();

    private ListOfDice chosenDiceList;
    private ListOfDice drawnDiceList;

    private void setChosenDicesListImageView() {
        chosenDiceImageView.add(0, selectedDice1);
        chosenDiceImageView.add(1, selectedDice2);
        chosenDiceImageView.add(2, selectedDice3);
        chosenDiceImageView.add(3, selectedDice4);
        chosenDiceImageView.add(4, selectedDice5);
    }

    private void setDrawnDiceListImageView() {
        drawnDiceImageView.add(0, userDice1img);
        drawnDiceImageView.add(1, userDice2img);
        drawnDiceImageView.add(2, userDice3img);
        drawnDiceImageView.add(3, userDice4img);
        drawnDiceImageView.add(4, userDice5img);
    }

    private GameLogic game = new GameLogic();

    public void initialize() {
        setChosenDicesListImageView();
        setDrawnDiceListImageView();
        //playerDice = new ListOfDice();
    }

    @FXML
    public void rollDice() {

        ListOfDice listOfDice = new ListOfDice();
        drawnDiceList = listOfDice;
        //ListOfDice l1 = new ListOfDice();
        //playerDice = game.getPlayerUserDicesList();

        //showUserScoreInLabel(playerUserDices);
        //showCpuScoreInLabel(computerUserDices);

        //messageLabel.setText("Select numbers to roll again");

        showCpuDiceImages(game);
        showUserDiceImages(game);

        //game.getPlayerUserDicesList().setDiceList(new ListOfDice());
        //showUserDiceImages(game.getPlayerUserDicesList());
        //showUserDiceImages(game.setUserDices());
    }

//    private void showUserScoreInLabel(ListOfDice userlList) {
//        score1.setText(userlList.getDiceListValueAsString(0));
//        score2.setText(userlList.getDiceListValueAsString(1));
//        score3.setText(userlList.getDiceListValueAsString(2));
//        score4.setText(userlList.getDiceListValueAsString(3));
//        score5.setText(userlList.getDiceListValueAsString(4));
//    }
//
//    private void showCpuScoreInLabel(ListOfDice compList) {
//        cpuScore1.setText(compList.getDiceListValueAsString(0));
//        cpuScore2.setText(compList.getDiceListValueAsString(1));
//        cpuScore3.setText(compList.getDiceListValueAsString(2));
//        cpuScore4.setText(compList.getDiceListValueAsString(3));
//        cpuScore5.setText(compList.getDiceListValueAsString(4));
//    }

    private void showCpuDiceImages(GameLogic game) {
        cpuDice1img.setImage(game.getCpuUserDicesList().getDiceImage(0));
        cpuDice2img.setImage(game.getCpuUserDicesList().getDiceImage(1));
        cpuDice3img.setImage(game.getCpuUserDicesList().getDiceImage(2));
        cpuDice4img.setImage(game.getCpuUserDicesList().getDiceImage(3));
        cpuDice5img.setImage(game.getCpuUserDicesList().getDiceImage(4));
    }

    private void showUserDiceImages(GameLogic game) {
        userDice1img.setImage(game.getPlayerUserDicesList().getDiceImage(0));
        userDice2img.setImage(game.getPlayerUserDicesList().getDiceImage(1));
        userDice3img.setImage(game.getPlayerUserDicesList().getDiceImage(2));
        userDice4img.setImage(game.getPlayerUserDicesList().getDiceImage(3));
        userDice5img.setImage(game.getPlayerUserDicesList().getDiceImage(4));
    }

    @FXML
    private void selectDice1() {
        game.getSelectedDices().add(0, game.getPlayerUserDicesList().getDice(0));
        userDice1img.imageProperty().set(null);
        chosenDiceImageView.get(0).setImage(game.getSelectedDices().get(0).getDiceImage());
        chosenDiceImageView.remove(0);
    }

    @FXML
    private void selectDice2() {
        game.getSelectedDices().add(0, game.getPlayerUserDicesList().getDice(1));
        userDice2img.imageProperty().set(null);
        chosenDiceImageView.get(0).setImage(game.getSelectedDices().get(0).getDiceImage());
        chosenDiceImageView.remove(0);
    }

    @FXML
    private void selectDice3() {
        game.getSelectedDices().add(0, game.getPlayerUserDicesList().getDice(2));
        userDice3img.imageProperty().set(null);
        chosenDiceImageView.get(0).setImage(game.getSelectedDices().get(0).getDiceImage());
        chosenDiceImageView.remove(0);
    }

    @FXML
    private void selectDice4() {
        game.getSelectedDices().add(0, game.getPlayerUserDicesList().getDice(3));
        userDice4img.imageProperty().set(null);

        chosenDiceImageView.get(0).setImage(game.getSelectedDices().get(0).getDiceImage());
        chosenDiceImageView.remove(0);
    }

    @FXML
    private void selectDice5() {
        game.getSelectedDices().add(0, game.getPlayerUserDicesList().getDice(4));
        userDice5img.imageProperty().set(null);
        chosenDiceImageView.get(0).setImage(game.getSelectedDices().get(0).getDiceImage());
        chosenDiceImageView.remove(0);
    }

    @FXML
    private void removeDice1() {
        game.getRemovedDices().add(0, game.getSelectedDices().get(0));
        selectedDice1.imageProperty().set(null);
        chosenDiceImageView.add(selectedDice1);
        userDice1img.setImage(game.getRemovedDices().get(0).getDiceImage());
    }

    @FXML
    private void removeDice2() {
        game.getRemovedDices().add(0, game.getSelectedDices().get(1));
        selectedDice2.imageProperty().set(null);
        chosenDiceImageView.add(selectedDice2);
        userDice2img.setImage(game.getRemovedDices().get(0).getDiceImage());
    }

    @FXML
    private void removeDice3() {
        game.getRemovedDices().add(0, game.getSelectedDices().get(2));
        selectedDice3.imageProperty().set(null);
        chosenDiceImageView.add(selectedDice3);
        userDice3img.setImage(game.getRemovedDices().get(0).getDiceImage());
    }

    @FXML
    private void removeDice4() {
        game.getRemovedDices().add(0, game.getPlayerUserDicesList().getDice(3));
        selectedDice4.imageProperty().set(null);
        chosenDiceImageView.add(selectedDice4);
        userDice4img.setImage(game.getRemovedDices().get(0).getDiceImage());

    }

    @FXML
    private void removeDice5() {
        game.getRemovedDices().add(0, game.getPlayerUserDicesList().getDice(4));
        selectedDice5.imageProperty().set(null);
        chosenDiceImageView.add(selectedDice5);
        userDice5img.setImage(game.getRemovedDices().get(0).getDiceImage());
    }
}
