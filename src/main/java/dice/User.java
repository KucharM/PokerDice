package dice;

public class User {
    private ListOfDice userDicesList = null;
    private int score = 0;

    public User() {
        this.userDicesList = new ListOfDice();
    }

    public ListOfDice getUserDiceList() {
        return this.userDicesList;
    }

    public void setUserDicesList(ListOfDice list) {
        this.userDicesList = list;
    }

    public int getScore() {
        return score;
    }
}
