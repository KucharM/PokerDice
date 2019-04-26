package dice;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class ListOfDice {
    private List<Dice> diceList;

    public ListOfDice() {
        this.diceList = createDiceList(5);
    }

    //method creates list of five dices with different values
    public List<Dice> createDiceList(int x) {
        List<Dice> list = new ArrayList<>();

        for (int i = 0; i < x; i++)
            list.add(new Dice());

        return list;
    }

    //GETTERS
    public List<Dice> getDiceList() {
        return diceList;
    }

    //method returns list of dices values
    public List<Integer> getListOfValues(List<Dice> list) {
        List<Integer> listOfValues = new ArrayList<>();
        for (Dice dice: list) {
            listOfValues.add(dice.getDiceValue());
        }
        return listOfValues;
    }

    public void setDice(int index, Dice dice) {
        Dice dice1 = diceList.get(index);
        dice1 = dice;
    }

    public void setDiceList(List<Dice> diceList) {
        this.diceList = diceList;
    }

    public Dice getDice(int index) {
        return diceList.get(index);
    }

    public int getDiceValue(int index) {
        return diceList.get(index).getDiceValue();
    }

    public Image getDiceImage(int index) {
        return diceList.get(index).getDiceImage();
    }

    @Override
    public String toString() {
        return "List of dice: " + diceList.get(0) + " " + diceList.get(1) + " " + diceList.get(2) +
                " " + diceList.get(3) + " " + diceList.get(4);
    }
}
