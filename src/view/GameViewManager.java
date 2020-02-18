package view;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.tank.Tank;
import sample.solid.Solid;
import java.util.ArrayList;
import java.util.List;


public class GameViewManager {


    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;

    private Stage menuStage;

    private List<Node> sceneObjects = new ArrayList<>();

    private static final int GAME_WIDTH = 750;
    private static final int GAME_HEIGHT = 750;

    private GridPane backgroundGridPane;
    private final static String BACKGROUND_IMAGE = "view/resources/terrainTiles_default.png";
  /*  Tank tankCreate;
    Solid tankSolid  = new Solid();*/


    private void createBackground() {
        backgroundGridPane = new GridPane();

        for (int i = 0; i < 9; i++) {
            ImageView backgroundImage1 = new ImageView(BACKGROUND_IMAGE);
            GridPane.setConstraints(backgroundImage1, i % 3, i / 3);
            backgroundGridPane.getChildren().add(backgroundImage1);
        }
        gamePane.getChildren().addAll(backgroundGridPane);

    }
    private void createKeyListeners() {
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.LEFT){

                }else if(keyEvent.getCode() == KeyCode.RIGHT){

                }
            }
        });

        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

            }
        });
    }

    public Stage getGameStage() {
        //createBackground();
        return gameStage;
    }
    public GameViewManager(){
        initializeStage();
        createBackground();
        addObject();
        createKeyListeners();
    }

    public void createNewGame(Stage menuStage){
        this.menuStage = menuStage;
        this.menuStage.hide();
        gameStage.show();
    }

    private void initializeStage() {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setTitle("SeriousTank");
        gameStage.setScene(gameScene);

    }
    private void addObject() {//Вот тут мы добавляем стартовые обьекты на сцене: tank, brick wall, immortal wall
        Solid testBlock = new Solid();
        sceneObjects.add(testBlock);
        Solid blockWithPosition  = new Solid(300,300,"ff");
        sceneObjects.add(blockWithPosition);
        Solid blockWithPosAndSize = new Solid(500,300,20,30,"view/resources/tank_blue.png");
        sceneObjects.add(blockWithPosAndSize);
        //Tank tank = new Tank(100,200);
        gamePane.getChildren().addAll(sceneObjects);
    }
}
