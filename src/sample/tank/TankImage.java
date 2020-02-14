package sample.tank;

import javafx.scene.image.Image;

public enum TankImage{
    BLUE("view/resources/tank_blue.png"),
    GREEN("view/resources/tank_green.png");

    private String urlTank;

    private TankImage(String urlTank){
        this.urlTank = urlTank;
    }

    public String getUrlTank(){
        return this.urlTank;
    }
}
