package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.MainMenuButton;

import java.util.ArrayList;
import java.util.List;


public class ViewManager {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    private static final String BACKGROUND_IMAGE = "";

    private static final int MENU_BUTTONS_START_X = 100;
    private static final int MENU_BUTTONS_START_Y = 100;

    List<MainMenuButton> menuButtonList;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    private GridPane backgroundGridPane;

    public ViewManager(){
        menuButtonList = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        mainStage.setTitle("SeriousTank");
        createButtons();
        //createBackground(); need image
    }

    private void addMenuButton(MainMenuButton button){
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + menuButtonList.size() * 100);
        menuButtonList.add(button);
        mainPane.getChildren().add(button);
    }

    public Stage getMainStage(){
        return  mainStage;
    }

    private void createButtons(){
        createStartButton();
        createScoreButton();
        createHelpButton();
        createExitButton();
    }

    private void createStartButton(){
        MainMenuButton startButton = new MainMenuButton("PLAY");
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //chose tank
                GameViewManager gameViewManager = new GameViewManager();
                gameViewManager.createNewGame(mainStage);
            }
        });
        addMenuButton(startButton);
    }

    private void createScoreButton(){
        MainMenuButton scoreButton = new MainMenuButton("SCORE");
        addMenuButton(scoreButton);
    }

    private void createHelpButton(){
        MainMenuButton helpButton = new MainMenuButton("HELP");
        addMenuButton(helpButton);
    }
    private void createExitButton(){
        MainMenuButton exitButton = new MainMenuButton("EXIT");
        addMenuButton(exitButton);
    }
    private void createBackground(){
        backgroundGridPane = new GridPane();
        for(int i = 0;i<9;i++){
            ImageView backgroundImage1 = new ImageView(BACKGROUND_IMAGE);
            GridPane.setConstraints(backgroundImage1, i%3,i/3);
            backgroundGridPane.getChildren().add(backgroundImage1);
        }
        mainPane.getChildren().addAll(backgroundGridPane);
    }
}
