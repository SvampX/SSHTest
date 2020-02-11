package sample.Interface;


import sample.simpletypes.Direction;

public interface Movable {
    public void move(int speed, Direction direction, sample.solid.Rectangle rectangle);

}
