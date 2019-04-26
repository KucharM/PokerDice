package comparators;

import dialog.Dialogs;
import dice.Dice;
import typesOfHands.HandRecognizer;

import java.util.List;
import java.util.Map;

public class DiceListComparator {
    private List<Dice> userDiceList;
    private List<Dice> cpuDiceList;
    private Map<Integer, Integer> userDiceMap;
    private Map<Integer, Integer> cpuDiceMap;

    public DiceListComparator(List<Dice> userDiceList, List<Dice> cpuDiceList) {
        this.userDiceList = userDiceList;
        this.cpuDiceList = cpuDiceList;
        userDiceMap = Mapper.mapDiceList(userDiceList);
        cpuDiceMap = Mapper.mapDiceList(cpuDiceList);
    }

    public Map<Integer, Integer> getUserDiceMap() {
        return userDiceMap;
    }

    public Map<Integer, Integer> getCpuDiceMap() {
        return cpuDiceMap;
    }

    public void compare() {
        boolean result = false;
//        System.out.println("user" + userDiceMap.values());
//        System.out.println("cpu" + cpuDiceMap.values());
        System.out.println();
        System.out.println("user score:");
        int sum = sumDicesValues(userDiceList);
        int value = HandRecognizer.recognizeDicesHand(userDiceMap);
//        HandRecognizer.recognizeDicesHand(userDiceMap);
        System.out.println("sum: " + sum);
        int userScore = sum * value;
        System.out.println("user score = " + userScore);

        System.out.println("cpu score:");
        int sum2 = sumDicesValues(cpuDiceList);
        int cpuValue = HandRecognizer.recognizeDicesHand(cpuDiceMap);
        System.out.println("sum: " + sum2);
        int cpuScore = sum2 * cpuValue;
        System.out.println("cpu score: " + cpuScore);

        if (userScore > cpuScore) {
            result = true;
//            System.out.println("user wins!");
            Dialogs.dialogUserWin();

        } else if (userScore < cpuScore) {
            result = false;
//            System.out.println("cpu wins!");
            Dialogs.dialogCpuWin();
        }
    }

    public int sumDicesValues(List<Dice> diceList) {
        int sum = 0;
        if (diceList.size() == 5) {
            for (Dice d : diceList) {
                sum += d.getDiceValue();
            }
        }
        return sum;
    }
}
