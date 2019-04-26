package dice;

import comparators.Mapper;
import typesOfHands.Straight;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CpuLogic {

    public List<Dice> cpuAlgorithm(List<Dice> drawnCpuDiceList, List<Dice> chosenDiceList, int nrOfRoll) {
        Map<Integer, Integer> cpuMap = Mapper.mapDiceList(drawnCpuDiceList);
        for (Map.Entry<Integer, Integer> map : cpuMap.entrySet()) {
            if (map.getValue() >= 2 && nrOfRoll != 0) {
                chosenDiceList.addAll(getDicesListByValue(drawnCpuDiceList, map.getKey()));
                drawnCpuDiceList.removeAll(chosenDiceList);
            }
            if (nrOfRoll == 0) {
                chosenDiceList.addAll(drawnCpuDiceList);
                drawnCpuDiceList.clear();
            }
            if (Straight.isStraight(cpuMap)) {
                chosenDiceList.addAll(drawnCpuDiceList);
                nrOfRoll = 0;
            }
        }
        return chosenDiceList;
    }

    public List<Dice> getDicesListByValue(List<Dice> diceList, int value) {
        return diceList.stream()
                .filter(dice -> dice.getDiceValue() == value)
                .collect(Collectors.toList());
    }
}
