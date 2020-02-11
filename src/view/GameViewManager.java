package view;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class GameViewManager {
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;

    private static final int GAME_WIDTH = 1024;
    private static final int GAME_HEIGHT = 768;

    private GridPane gridPane1;
    private GridPane gridPane2;
    private final static String BACKGROUND_IMAGE = "view/resources/terrainTiles_default.png";
    private final static String TANK_IMAGE_GREEN = "view/resources/tank_green.png";
    private Node tank;
    boolean goNorth, goSouth, goEast, goWest;


    private void createBackgroundAndTank() {
        gridPane1 = new GridPane();
        gridPane2 = new GridPane();
        tank = new ImageView(TANK_IMAGE_GREEN);
        Group tank1 = new Group();
        tank1.getChildren().add(tank);

        for (int i = 0; i < 12; i++) {
            ImageView backgroundImage1 = new ImageView(BACKGROUND_IMAGE);
            ImageView backgroundImage2 = new ImageView(BACKGROUND_IMAGE);
            GridPane.setConstraints(backgroundImage1, i % 3, i / 3);
            GridPane.setConstraints(backgroundImage2, i % 3, i / 3);
            gridPane1.getChildren().add(backgroundImage1);
            gridPane1.getChildren().add(backgroundImage2);
        }

        gridPane2.setLayoutY(-1024);

        gamePane.getChildren().addAll(gridPane1, gridPane2, tank1);
    }

    public GameViewManager() {
        initializeStage();
        createKeyListener();
    }

    private void createKeyListener() {
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        goNorth = true;
                        break;
                    case DOWN:
                        goSouth = true;
                        break;
                    case LEFT:
                        goWest = true;
                        break;
                    case RIGHT:
                        goEast = true;
                        break;
                }
            }
        });
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        goNorth = false;
                        break;
                    case DOWN:
                        goSouth = false;
                        break;
                    case LEFT:
                        goWest = false;
                        break;
                    case RIGHT:
                        goEast = false;
                        break;
                }
            }
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long number) {
                int dx = 0;
                int dy = 0;

                if (goNorth) {
                    dy -= 1;
                    tank.setRotate(180.0);
                }
                if (goSouth) {
                    dy += 1;
                    tank.setRotate(0.0);
                }
                if (goEast) {
                    dx += 1;
                    tank.setRotate(270.0);
                }
                if (goWest) {
                    dx -= 1;
                    tank.setRotate(90.0);
                }
                moveTankBy(dx, dy);
            }
        };
        timer.start();
    }

    private void moveTankBy(int dx, int dy) {
        if (dx == 0 && dy == 0) return;

        final double cx = tank.getBoundsInLocal().getWidth() / 2;
        final double cy = tank.getBoundsInLocal().getHeight() / 2;

        double x = cx + tank.getLayoutX() + dx;
        double y = cy + tank.getLayoutY() + dy;

        moveTankTo(x, y);
    }

    private void moveTankTo(double x, double y) {
        final double cx = tank.getBoundsInLocal().getWidth() / 2;
        final double cy = tank.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
                x + cx <= GAME_WIDTH &&
                y - cy >= 0 &&
                y + cy <= GAME_HEIGHT) {
            tank.relocate(x - cx, y - cy);
        }
    }

    public Stage getGameStage() {
        createBackgroundAndTank();
        return gameStage;
    }

    private void initializeStage() {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setTitle("SeriousTank");
        gameStage.setScene(gameScene);
    }
}
