package sample.tank;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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

    public void moveTank(Scene scene) {
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
                    dy -= 1.5;
                    newTank.setRotate(180.0);
                }
                if (goDown) {
                    dy += 1.5;
                    newTank.setRotate(0.0);
                }
                if (goLeft) {
                    dx -= 1.5;
                    newTank.setRotate(90.0);
                }
                if (goRight) {
                    dx += 1.5;
                    newTank.setRotate(270.0);
                }
              moveTankBy(dx,dy);
            }
        };
        animationTimer.start();
    }
    public void moveTankBy(int dx, int dy) {
        if (dx == 0 && dy == 0)
            return;
        final double cx = newTank.getBoundsInLocal().getWidth() / 2;
        final double cy = newTank.getBoundsInLocal().getHeight() / 2;

        double x = cx + newTank.getLayoutX() + dx;
        double y = cy + newTank.getLayoutY() + dy;
        moveTankTo(x, y);
    }
    public void moveTankTo(double x, double y) {
        final double cx = newTank.getBoundsInLocal().getWidth() / 2;
        final double cy = newTank.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
                x + cx <= 750 &&
                y - cy >= 0 &&
                y + cy <= 750) {
            newTank.relocate(x - cx, y - cy);
        }
    }
    /*public void createTank( List list, AnchorPane anchorPane){
        newTank = new Solid(newTank);
        newTank.setLayoutX(500);
        newTank.setLayoutY(500);
        newTank.setFitHeight(40);
        newTank.setFitWidth(40);
        list.add(newTank);
        anchorPane.getChildren().addAll(newTank);
    }*/


    @Override
    public void move(int speed, Direction direction, Rectangle rectangle) {

    }
}
