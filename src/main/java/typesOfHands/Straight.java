package typesOfHands;

import java.util.*;

public class Straight extends DicesHand{
    private static List<Integer> lowStraight = new ArrayList<>();
    private static List<Integer> highStraight = new ArrayList<>();
    public static final int STRAIGHT_RANGE = 37;

    @Override
    public int getRange() {
        return STRAIGHT_RANGE;
    }

    public static boolean isStraight(Map<Integer, Integer> diceMap) {
        if (isLowStraight(diceMap) || isHighStraight(diceMap)) {
            return true;
        }
        return false;
    }

    private static boolean isLowStraight(Map<Integer, Integer> diceMap) {
        setLowStraight(lowStraight);
        if (diceMap.keySet().equals(lowStraight)) {
            return true;
        }
        return false;
    }

    private static boolean isHighStraight(Map<Integer, Integer> diceMap) {
        setHighStraight(highStraight);
        if (diceMap.keySet().equals(highStraight)) {
            return true;
        }
        return false;
    }

    private static void setLowStraight(List<Integer> lowStraight) {
        for (int i = 1; i <= 5; i++) {
            lowStraight.add(i);
        }
    }

    private static void setHighStraight(List<Integer> highStraigh) {
        for (int i = 2; i <= 6; i++) {
            highStraigh.add(i);
        }
    }
}
