package sample;

public class Solid<T extends Solid> {
    private Rectangle rectangle;

    boolean collision(T obj1, T obj2) {
        for (Point point : obj1.getRectangle().getSquare()) {
            if(obj2.getRectangle().getSquare().contains(point)){
                return true;
            }
        }
        return false;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
