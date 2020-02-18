package sample.solid;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Solid<T extends Solid> extends ImageView {
    private Rectangle position;
    private static String BACKGROUND_IMAGE = "sample/solid/resources/default.png";
    private static String TANK_IMAGE = "view/resources/tank_blue.png";

    public Solid() {
        super(BACKGROUND_IMAGE);
    }

    public Solid(Node tank) {
        super(TANK_IMAGE);
    }


    boolean collision(T obj1, T obj2) {
        for (Point point : obj1.getPosition().getSquare()) {
            if (obj2.getPosition().getSquare().contains(point)) {
                return true;
            }
        }
        return false;
    }

    public Rectangle getPosition() {
        return position;
    }
}
