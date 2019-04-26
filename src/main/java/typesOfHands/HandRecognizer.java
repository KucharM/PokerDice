package typesOfHands;

import java.util.*;

public class HandRecognizer {
    public static int recognizeDicesHand(Map<Integer, Integer> dicesMap) {
        int handValue = 0;
        List<Integer> values = new ArrayList<>(dicesMap.values());

        if (values.size() == 3 && values.contains(2)) {
            handValue = 6;
            System.out.println("two pairs: ");

        } else if (values.size() == 4 && values.contains(2)) {
            handValue = 2;
            System.out.println("one pair: ");

        } else if (values.size() == 3 && values.contains(3)) {
            handValue = 20;
            System.out.println("three of a kind: ");

        } else if (values.size() == 2 && values.contains(3)) {
            handValue = 106;
            System.out.println("fulll house: ");

        } else if (values.size() == 2 && values.contains(4)) {
            handValue = 495;
            System.out.println("four of a kind: ");

        } else if (values.size() == 1) {
            handValue = 2872;
            System.out.println("five of a kind: ");

        } else if (values.size() == 5) {
            if (Straight.isStraight(dicesMap))
                handValue = 37;
            else
                handValue = 1;
            System.out.println("straight: ");
        }

        return handValue;
    }

    private static int getDiceByValue(Map<Integer, Integer> diceMap, int value) {
        int diceValue = 0;

        for (Map.Entry<Integer, Integer> map : diceMap.entrySet()) {
            int key = map.getKey();
            int val = map.getValue();

            if (val == value)
                diceValue = key;
        }
        return diceValue;
    }
}

