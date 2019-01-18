package gui.controllers;

import dice.CompUser;
import dice.ListOfDice;
import dice.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameWindowController {
    @FXML
    private Label messageLabel;
    @FXML
    private Button rollDiceButton;
    @FXML
    private Label cpuScore1;
    @FXML
    private Label cpuScore2;
    @FXML
    private Label cpuScore3;
    @FXML
    private Label cpuScore4;
    @FXML
    private Label cpuScore5;
    @FXML
    private Label score1;
    @FXML
    private Label score2;
    @FXML
    private Label score3;
    @FXML
    private Label score4;
    @FXML
    private Label score5;

    @FXML
    public void rollDice() {

            CompUser compUser = new CompUser(new ListOfDice());
            User user = new User(new ListOfDice());

            ListOfDice userDices = user.getUserDices();
            ListOfDice compDices = compUser.getCpuDiceList();

            showScoreInLabel(userDices, compDices);

            //
            messageLabel.setText("Select numbers to roll again");


    }

    private void showScoreInLabel(ListOfDice userlList, ListOfDice compList) {

        score1.setText(userlList.getDiceListValueAsString(0));
        score2.setText(userlList.getDiceListValueAsString(1));
        score3.setText(userlList.getDiceListValueAsString(2));
        score4.setText(userlList.getDiceListValueAsString(3));
        score5.setText(userlList.getDiceListValueAsString(4));


        cpuScore1.setText(compList.getDiceListValueAsString(0));
        cpuScore2.setText(compList.getDiceListValueAsString(1));
        cpuScore3.setText(compList.getDiceListValueAsString(2));
        cpuScore4.setText(compList.getDiceListValueAsString(3));
        cpuScore5.setText(compList.getDiceListValueAsString(4));

    }
}
