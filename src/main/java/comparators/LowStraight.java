package comparators;

import dice.Dice;

import java.util.List;

public class LowStraight {
    public int checkIfLowStraight(List<Dice>diceList) {
      //  if (max(diceList) == 5)

        return 0;
    }

    private int max(List<Dice> diceList) {
        int max = 0;
        for (int i = 0; i < diceList.size(); i++) {
            if (diceList.get(i).getDiceValue() > max)
                max = diceList.get(i).getDiceValue();
        }
        return max;
    }
}
