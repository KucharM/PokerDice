package comparators;


import dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class FiveOfAKind {

    public static int checkIfFiveOfAKind(List<Dice> diceList) {
        int value1 = 1, value2 = 2, value3 = 3, value4 = 4, value5 = 5, value6 = 6;

        for (Dice dice: diceList) {
            if (dice.getDiceValue() == value1 || dice.getDiceValue() == value2 || dice.getDiceValue() == value3 ||
            dice.getDiceValue() == value4 || dice.getDiceValue() == value5 || dice.getDiceValue() == value6) {
            }
        }
        System.out.println("Five of a kind " + diceList.get(0).getDiceValue());
        return diceList.get(0).getDiceValue();
    }

    public static void main(String[] args) {
        List<Dice> list1 = new ArrayList<>();
        List<Dice> list2 = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            list1.add(i, new Dice());
            list2.add(i, new Dice());
        }

        for (Dice dice: list1) {
            dice.setDiceValue(5);
        }

        for (Dice dice: list2) {
            dice.setDiceValue(4);
        }

        FiveOfAKind.checkIfFiveOfAKind(list1);
        FiveOfAKind.checkIfFiveOfAKind(list2);
        System.out.println();

        System.out.println(FiveOfAKind.checkIfFiveOfAKind(list1) < FiveOfAKind.checkIfFiveOfAKind(list2));

    }
}
