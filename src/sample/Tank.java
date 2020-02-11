package sample;

import javafx.scene.Node;
import sample.Interface.Alive;
import sample.Interface.Movable;
import sample.solid.Solid;
import view.GameViewManager;

import java.awt.event.KeyEvent;

public class Tank extends Solid implements Alive, Movable {
    private final static String TANK_IMAGE_BLUE = "view/resources/tank_blue.png";
    private final static String TANK_IMAGE_GREEN = "view/resources/tank_green.png";

    boolean goUp, goDown, goRight, goLeft;

    private int TANK_HEALTH = 100;

    @Override
    public boolean isAlive() {
        if (TANK_HEALTH > 0)
            return true;
        else
            return false;
    }

    @Override
    public int getLife() {
        return TANK_HEALTH;
    }

    @Override
    public void move() {

    }
}
