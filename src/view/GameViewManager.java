package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
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
    private final static String TANK_IMAGE = "view/resources/tank_green.png";
    private Node tank;


    private void createBackgroundAndTank() {
        gridPane1 = new GridPane();
        gridPane2 = new GridPane();
        tank = new ImageView(TANK_IMAGE);
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
        createKeyListners();
    }

    private void createKeyListners() {

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
