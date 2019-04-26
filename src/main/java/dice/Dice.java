package dice;

import javafx.scene.image.Image;
import java.util.Random;

public class Dice {
    private int diceValue;
    private Image diceImage;

    public Dice() {
        Random random = new Random();
        int value = random.nextInt(6) + 1;
        diceValue = value;
        diceImage = new MapOfDiceImage().getMapOfDiceImage().get(diceValue);
    }

    //GETTERS
    public int getDiceValue() {
        return diceValue;
    }

    public Image getDiceImage() {
        return diceImage;
    }

    //to String method
    public String toString() {
        return "number " + diceValue;
    }
}

