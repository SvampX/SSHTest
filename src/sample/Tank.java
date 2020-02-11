package sample;

import sample.Interface.Alive;

public class Tank implements Alive {
    private final static String  TANK_IMAGE_BLUE = "view/resources/tank_blue.png";
    private final static String  TANK_IMAGE_GREEN = "view/resources/tank_green.png";
    private final int TANK_HEALTH = 100;

    @Override
    public boolean isAlive() {
        if (TANK_HEALTH < 1)
            return true;
        else
            return false;
    }

    @Override
    public int getLife() {
        return TANK_HEALTH;
    }
}
