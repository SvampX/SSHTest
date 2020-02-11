package sample.Interface;

import javafx.scene.control.skin.TextInputControlSkin;

public interface Movable {
    public void move(int speed, TextInputControlSkin.Direction direction, sample.solid.Rectangle rectangle);

}
