package comparators;

import dice.Dice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapper {
    public static Map<Integer, Integer> mapDiceList(List<Dice> drawnCpuDiceList) {
        Map<Integer, Integer> diceListValuesMap = new HashMap<>();
        for (Dice dice : drawnCpuDiceList) {
            if (diceListValuesMap.containsKey(dice.getDiceValue())) {
                int value = diceListValuesMap.get(dice.getDiceValue());
                diceListValuesMap.put(dice.getDiceValue(), ++value);
            } else {
                diceListValuesMap.put(dice.getDiceValue(), 1);
            }
        }
        return diceListValuesMap;
    }
}
