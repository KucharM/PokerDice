package dice;

public class User {
    private ListOfDice userDicesList;
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

//    public int getDiceValue() {
//        return userDicesList.getDiceValue();
//    }

    public int getScore() {
        return score;
    }
}
