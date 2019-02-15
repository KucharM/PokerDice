package dice;

import java.util.HashMap;
import java.util.Map;

public class HandRecognizer {


    public Map<Integer, Integer> recognizeHand(ListOfDice listToRecognize) {
        Map<Integer, Integer> handValuesMap = new HashMap<>();
        for (Dice d : listToRecognize.getDiceList()) {
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

    public void handResult(ListOfDice listOfDice) {
        Map<Integer, Integer> result = recognizeHand(listOfDice);

        for (Map.Entry<Integer, Integer> map : result.entrySet()) {
            int key = map.getKey();
            int val = map.getValue();

            if (val == 2)
                System.out.println("pair of " + key);
            else if (val == 3)
                System.out.println("tree of a " + key);
            else if (val == 4)
                System.out.println("four of a kind " + key);
            else if (val == 5)
                System.out.println("five of a kind " + key);
        }
    }

    public static void main(String[] args) {
        ListOfDice listOfDice = new ListOfDice();

        HandRecognizer handRecognizer = new HandRecognizer();
        handRecognizer.handResult(listOfDice);
    }
}
