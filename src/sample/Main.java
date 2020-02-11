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


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        AnchorPane mainPane = new AnchorPane();
        Button buttonStart = new Button();
        buttonStart.setText("START");
        buttonStart.setLayoutX(150);
        buttonStart.setLayoutY(150);
        buttonStart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                startNewGame(primaryStage);
            }
        });
        mainPane.getChildren().add(buttonStart);
        Scene mainScene= new Scene(mainPane,500,300);
        primaryStage.setTitle("SeriousTank");
        primaryStage.setScene(mainScene);


        primaryStage.show();
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
