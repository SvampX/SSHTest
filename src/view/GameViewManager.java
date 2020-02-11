package view;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class GameViewManager {
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private List<Node> sceneObjects = new ArrayList<>();

    private static final int GAME_WIDTH = 750;
    private static final int GAME_HEIGHT = 750;

    private GridPane backgroundGridPane;
    private GridPane gridPane2;
    private final static String  BACKGROUND_IMAGE = "view/resources/terrainTiles_default.png";

    private void createBackground(){
        backgroundGridPane = new GridPane();

        for(int i = 0;i<9;i++){
            ImageView backgroundImage1 = new ImageView(BACKGROUND_IMAGE);
            GridPane.setConstraints(backgroundImage1, i%3,i/3);
            backgroundGridPane.getChildren().add(backgroundImage1);
        }

        gamePane.getChildren().addAll(backgroundGridPane);
    }

    public GameViewManager(){
        initializeStage();
        createKeyListners();
    }

    private void createKeyListners() {

    }
    public Stage getGameStage(){
        createBackground();
        return gameStage;
    }
    private void initializeStage() {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane,GAME_WIDTH,GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setTitle("SeriousTank");
        gameStage.setScene(gameScene);
        //Вот тут мы добавляем стартовые обьекты на сцене: tank, brick wall, immortal wall
        //sceneObjects.add();
    }
}
