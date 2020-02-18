package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.GameViewManager;
import view.ViewManager;


public class Main extends Application {
    /* TODO: subscene from main menu 6*/
    /* TODO: choose tank subscene 7- 8*/

    @Override
    public void start(Stage primaryStage) throws Exception{
        ViewManager manager = new ViewManager();
        primaryStage = manager.getMainStage();
        primaryStage.show();
       /*
        mainPane.getChildren().add(buttonStart);
        Scene mainScene= new Scene(mainPane,500,300);
        primaryStage.

        */
    }
    public static void startNewGame(Stage curStage){
        curStage.close();
        GameViewManager gameViewManager = new GameViewManager();
        Stage newStage = gameViewManager.getGameStage();
        newStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
