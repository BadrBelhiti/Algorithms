package datastructures.experimental;

import java.awt.*;

public class TwoDimensionalBST {

    private Node2D root;

    public void insert(Point point){
        if (root == null){
            this.root = new Node2D(point);
            return;
        }
        insertRecursively(point, root);
    }

    private void insertRecursively(Point entry, Node2D parent){
        int compX = Integer.compare(entry.x, parent.getX());
        int compY = Integer.compare(entry.y, parent.getY());

        if (compX > 0 && compY > 0){
            if (parent.bottomRight == null){
                parent.bottomRight = new Node2D(entry);
            } else {
                insertRecursively(entry, parent.bottomRight);
            }
        } else if (compX > 0){
            if (parent.topRight == null){
                parent.topRight = new Node2D(entry);
            } else {
                insertRecursively(entry, parent.topRight);
            }
        } else if (compY > 0){
            if (parent.bottomLeft == null){
                parent.bottomLeft = new Node2D(entry);
            } else {
                insertRecursively(entry, parent.bottomLeft);
            }
        } else {
            if (parent.topLeft == null){
                parent.topLeft = new Node2D(entry);
            } else {
                insertRecursively(entry, parent.topLeft);
            }
        }
    }

    public Node2D findClosestTo(Point point){
        return traverse(point, root);
    }
    
    public Node2D traverse(Point point, Node2D parent){
        int compX = Integer.compare(point.x, parent.getX());
        int compY = Integer.compare(point.y, parent.getY());
        
        if (compX > 0 && compY > 0){
            if (parent.bottomRight == null){
                return parent;
            } else {
                return traverse(point, parent.bottomRight);
            }
        } else if (compX > 0){
            if (parent.topRight == null){
                return parent;
            } else {
                return traverse(point, parent.topRight);
            }
        } else if (compY > 0){
            if (parent.bottomLeft == null){
                return parent;
            } else {
                return traverse(point, parent.bottomLeft);
            }
        } else {
            if (parent.topLeft == null){
                return parent;
            } else {
                return traverse(point, parent.topLeft);
            }
        }
    }
    
    public void depthFirst(){
        depthFirst(root);
    }

    public void depthFirst(Node2D node){

        if (node == null){
            return;
        }

        depthFirst(node.bottomRight);
        depthFirst(node.bottomLeft);
        depthFirst(node.topRight);
        depthFirst(node.topLeft);
        System.out.println(node);
    }

}
