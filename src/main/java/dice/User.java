package dice;

public class User {
    private ListOfDice userDices;

    public User(ListOfDice userDices) {
        this.userDices = userDices;
    }

    public ListOfDice getUserDices() {
        return userDices;
    }
}
