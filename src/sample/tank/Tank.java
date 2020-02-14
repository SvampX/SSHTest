package sample.tank;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import sample.Interface.Alive;
import sample.Interface.Movable;
import sample.simpletypes.Direction;
import sample.solid.Rectangle;
import sample.solid.Solid;
import java.util.List;

public class Tank extends Solid implements Alive, Movable {
    private final static String TANK_IMAGE_BLUE = "view/resources/tank_blue.png";
    private final static String TANK_IMAGE_GREEN = "view/resources/tank_green.png";

    private int tank_health = 100;
    boolean goUp, goDown, goRight, goLeft;
    Solid newTank = new Solid();
    Node tankSUKA;


    @Override
    public boolean isAlive() {
        if (tank_health > 0)
            return true;
        else
            return false;
    }

    @Override
    public int getLife() {
        return tank_health;
    }

    public void moveTank(Scene scene, Solid solid) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        goUp = true;
                        System.out.println("UP");
                        break;
                    case DOWN:
                        goDown = true;
                        System.out.println("DOWN");
                        break;
                    case LEFT:
                        goLeft = true;
                        System.out.println("LEFT");
                        break;
                    case RIGHT:
                        goRight = true;
                        System.out.println("RiGHT");
                        break;
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        goUp = false;
                        break;
                    case DOWN:
                        goDown = false;
                        break;
                    case LEFT:
                        goLeft = false;
                        break;
                    case RIGHT:
                        goRight = false;
                        break;
                }
            }
        });
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                int dx = 0;
                int dy = 0;

                if (goUp) {
                    dy -= 1;
                    newTank.setRotate(180.0);
                }
                if (goDown) {
                    dy += 1;
                    newTank.setRotate(0.0);
                }
                if (goLeft) {
                    dx += 1;
                    newTank.setRotate(270.0);
                }
                if (goRight) {
                    dx -= 1;
                    tankSUKA.setRotate(90.0);
                }
                moveTankBy(dx, dy);
            }
        };
        animationTimer.start();
    }

    public void moveTankBy(int dx, int dy) {
        if (dx == 0 && dy == 0)
            return;
        final double cx = tankSUKA.getBoundsInLocal().getWidth() / 2;
        final double cy = tankSUKA.getBoundsInLocal().getHeight() / 2;

        double x = cx + tankSUKA.getLayoutX() + dx;
        double y = cy + tankSUKA.getLayoutY() + dy;
        moveTankTo(x, y);
    }

    public void moveTankTo(double x, double y) {
        final double cx = tankSUKA.getBoundsInLocal().getWidth() / 2;
        final double cy = tankSUKA.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
                x + cx <= 750 &&
                y - cy >= 0 &&
                y + cy <= 750) {
            newTank.relocate(x - cx, y - cy);
        }
    }

    public void createTank(Solid tank12, List list, AnchorPane anchorPane) {
        tank12 = new Solid(tank12);
        tank12.setLayoutX(500);
        tank12.setLayoutY(500);
        tank12.setFitHeight(40);
        tank12.setFitWidth(40);
        list.add(tank12);
        anchorPane.getChildren().addAll(tank12);
    }


    @Override
    public void move(int speed, Direction direction, Rectangle rectangle) {

    }
}
