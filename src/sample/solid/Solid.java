package sample.solid;

public class Solid<T extends Solid> {
    private Rectangle position;

    boolean collision(T obj1, T obj2) {
        for (Point point : obj1.getPosition().getSquare()) {
            if(obj2.getPosition().getSquare().contains(point)){
                return true;
            }
        }
        return false;
    }

    public Rectangle getPosition() {
        return position;
    }
}
