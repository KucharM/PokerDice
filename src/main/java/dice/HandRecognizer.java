package dice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandRecognizer {

    public Map<Integer, Integer> recognizeHand(List<Dice> listToRecognize) {
        Map<Integer, Integer> handValuesMap = new HashMap<>();
        for (Dice d : listToRecognize) {
            if (handValuesMap.containsKey(d.getDiceValue())) {
                int x = handValuesMap.get(d.getDiceValue());
                handValuesMap.put(d.getDiceValue(), x + 1);
            } else {
                handValuesMap.put(d.getDiceValue(), 1);
            }
        }
        System.out.println(handValuesMap);
        return handValuesMap;
    }
}