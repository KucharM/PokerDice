package dice;

import javafx.scene.image.Image;

import java.util.Map;
import java.util.HashMap;

public class MapOfDiceImage {
    private Map<Integer, Image> mapOfDiceImage;

    public MapOfDiceImage() {
        this.mapOfDiceImage = createMapOfDiceImage();
    }

    public Image getImage(Integer key){
        return mapOfDiceImage.get(key);
    }

    private Map<Integer, Image> createMapOfDiceImage () {
        HashMap<Integer, Image> map = new HashMap<>();

        map.put(1, new Image("/dices-img/Alea_1.png"));
        map.put(2, new Image("/dices-img/Alea_2.png"));
        map.put(3, new Image("/dices-img/Alea_3.png"));
        map.put(4, new Image("/dices-img/Alea_4.png"));
        map.put(5, new Image("/dices-img/Alea_5.png"));
        map.put(6, new Image("/dices-img/Alea_6.png"));

        return map;
    }
}
