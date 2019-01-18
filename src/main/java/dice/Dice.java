package dice;

import javafx.scene.image.Image;

import java.util.Random;

public class Dice {
    private int diceValue;
    private Image diceImage;

    public Dice() {
        Random random = new Random();
        this.diceValue = random.nextInt(6) + 1;
        //this.diceImage = new MapOfDiceImage().getImage(diceValue);
    }

    public int getDiceValue() {
        return diceValue;
    }

    public Image getDiceImage() {
        return diceImage;
    }

    @Override
    public String toString() {
        return "number " + diceValue;
    }
}
