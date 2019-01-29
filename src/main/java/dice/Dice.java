package dice;

import javafx.scene.image.Image;

import java.util.Random;

public class Dice {
    private int diceValue;
    private Image diceImage;

    public Dice() {
        Random random = new Random();
        this.diceValue = random.nextInt(6) + 1;
        this.diceImage = new MapOfDiceImage().getMapOfDiceImage().get(this.diceValue);
    }

    //GETTERS
    public int getDiceValue() {
        return this.diceValue;
    }

    public Image getDiceImage() {
        return this.diceImage;
    }

    //to String method
    public String toString() {
        return "number " + this.diceValue;
    }
}
