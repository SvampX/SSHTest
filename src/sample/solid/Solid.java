package sample.solid;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Solid extends ImageView {
    private Rectangle position;

    private static String DEFAULT_TEXTURE = "sample/solid/resources/default.png";


    public Solid() {//Default
        super(DEFAULT_TEXTURE);
    }
    public Solid(double x, double y,String texture) {//TODO: проверка на наличии пути
        super(DEFAULT_TEXTURE);
        try {
            super.setImage(new Image(texture));
        }catch (Exception e){
            System.out.println("Used default texture");
        }
        setLayoutX(x);
        setLayoutY(y);

    }
    public Solid(double x, double y, double height, double width,String texture){
        super(DEFAULT_TEXTURE);
        try {
            super.setImage(new Image(texture));
        }catch (Exception e){
            System.out.println("Used default texture");
        }
        setLayoutX(x);
        setLayoutY(y);
        setFitHeight(height);
        setFitWidth(width);
    }



    boolean collision(Solid obj1, Solid obj2) {
        for (Point point : obj1.getPosition().getSquare()) {
            if (obj2.getPosition().getSquare().contains(point)) {
                return true;
            }
        }
        return false;
    }

    public Rectangle getPosition() {
        return position;
    }
}
