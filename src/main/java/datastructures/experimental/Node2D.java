package datastructures.experimental;

import java.awt.*;

public class Node2D {

    private Point value;

    public Node2D topRight;
    public Node2D topLeft;
    public Node2D bottomRight;
    public Node2D bottomLeft;

    public Node2D(Point point){
        this.value = point;
    }

    public Node2D(int x, int y){
        this(new Point(x, y));
    }

    public Point getValue() {
        return value;
    }

    public int getX(){
        return value.x;
    }

    public int getY(){
        return value.y;
    }

    public String toString(){
        return value.toString();
    }

}
