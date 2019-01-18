package dice;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class ListOfDice {
    private List<Dice> diceList;

    public ListOfDice() {
        this.diceList = createDiceList();
    }

    //method creates list of five dices with different values
    private List<Dice> createDiceList() {
        ArrayList<Dice> list = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            list.add(new Dice());

        return list;
    }

    @Override
    public String toString() {
        return "List of dice: " + diceList.get(0) + " " + diceList.get(1) + " " + diceList.get(2) +
                " " + diceList.get(3) + " " + diceList.get(4);
    }

    public List<Dice> getDiceList() {
        return diceList;
    }

    //method returns single value of dice from list
    public int[] getDiceListValue() {
        int[] values = new int[5];

        for (int i = 0; i < 5; i++)
            values[i] = diceList.get(i).getDiceValue();

        return values;
    }

    //method returns string value of dice from list
    public String getDiceListValueAsString(int index) {
        return Integer.toString(diceList.get(index).getDiceValue());
    }
}
