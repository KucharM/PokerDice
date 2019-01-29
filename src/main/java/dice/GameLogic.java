package dice;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private User playerUser;
    private User computerUser;
    private List<Dice> selectedDices = new ArrayList<>();
    private List<Dice> removedDices = new ArrayList<>();

    public GameLogic() {
        this.playerUser = new User();
        this.computerUser = new User();
    }

    public ListOfDice setUserDices() {
        this.playerUser.setUserDicesList(new ListOfDice());
        return playerUser.getUserDiceList();
    }

    public ListOfDice setCpuUserDices() {
        this.computerUser.setUserDicesList(new ListOfDice());
        return computerUser.getUserDiceList();
    }

    public User getPlayerUser() {
        return playerUser;
    }

    public User getComputerUser() {
        return computerUser;
    }

    public ListOfDice getPlayerUserDicesList() {
        return this.playerUser.getUserDiceList();
    }

    public ListOfDice getCpuUserDicesList() {
        return this.computerUser.getUserDiceList();
    }

    public List<Dice> getSelectedDices() {
        return selectedDices;
    }

    public List<Dice> getRemovedDices() {
        return removedDices;
    }

}
