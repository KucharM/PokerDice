package dice;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private User user;
    private User cpuUser;
    private List<Dice> userChosenDiceList = new ArrayList<>();
    private List<Dice> cpuChosenDiceList = new ArrayList<>();

    public GameLogic() {
        this.user = new User();
        this.cpuUser = new User();
    }

    public List<Dice> getUserChosenDiceList() {
        return userChosenDiceList;
    }

    public List<Dice> getCpuChosenDiceList() {
        return cpuChosenDiceList;
    }

    public User getUser() {
        return user;
    }

    public User getCpuUser() {
        return cpuUser;
    }

//    public List<Dice> getSelectedDices() {
//        return selectedDices;
//    }
//
//    public List<Dice> getRemovedDices() {
//        return removedDices;
//    }

}
