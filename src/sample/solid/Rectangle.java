package sample.solid;

import java.util.ArrayList;
import java.util.List;

public class Rectangle {
    public Point getLeftHigh() {
        return leftHigh;
    }

    public Point getRightLow() {
        return rightLow;
    }

    private Point leftHigh;
    private Point rightLow;
    private List<Point> square = new ArrayList<>();

    public Rectangle(Point leftHigh, Point rightLow) {
        this.leftHigh = leftHigh;
        this.rightLow = rightLow;
    }

    List<Point> getSquare(){
        for(int i = leftHigh.getX();i <= rightLow.getX(); i++){
            for (int j = leftHigh.getY(); j <= rightLow.getY(); j++) {
                square.add(new Point(i,j));
            }
        }
        return square;
    }

    public void setLeftHigh(Point leftHigh) {
        this.leftHigh = leftHigh;
    }

    public void setRightLow(Point rightLow) {
        this.rightLow = rightLow;
    }
}
