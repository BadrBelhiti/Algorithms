package datastructures;


import datastructures.experimental.TwoDimensionalBST;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class DataStructureTester {

    public static void testArray(){
        Array<String> array = new Array<String>();

        array.add("1");
        array.add("Test");
        System.out.println(array);
        array.remove("Test");
        System.out.println(array);
        System.out.println(array.search("Test"));
    }

    public static void testLinkedList(){
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.addLast("Test");
        linkedList.addLast("Test2");
        linkedList.addLast("Test3");
        linkedList.addLast("Test2");
        System.out.println(linkedList.contains("test"));
        System.out.println(linkedList.contains("Test"));
        System.out.println(linkedList);

        while (!linkedList.isEmpty()) {
            System.out.println(linkedList.removeFirst());
        }
    }

    public static void testBST(){

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(0);
        bst.add(2);
        bst.add(-4);
        bst.add(45);
        bst.add(3);
        bst.add(3);
        bst.add(2);
        bst.add(5);
        System.out.println(bst);
    }

    public static void test2DBST(){

        Random random = new Random(3);
        TwoDimensionalBST twoDimensionalBST = new TwoDimensionalBST();


        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            Point point = new Point(random.nextInt(100) - 50, random.nextInt(100) - 50);
            points.add(point);
            twoDimensionalBST.insert(point);
        }

        Point search = new Point(random.nextInt(100) - 50, random.nextInt(100) - 50);

        twoDimensionalBST.depthFirst();
        System.out.println("Point: ");
        System.out.println(search);
        System.out.println("Closest Point: ");
        System.out.println(twoDimensionalBST.findClosestTo(search));
        System.out.println(closest(search, points));
    }

    public static Point closest(Point point, ArrayList<Point> points){
        if (points.isEmpty()){
            return null;
        }
        Point closest = points.get(0);

        for (Point curr : points){
            if (distanceSquared(curr, point) < distanceSquared(closest, point)){
                closest = curr;
            }
        }
        return closest;
    }

    private static int distanceSquared(Point a, Point b){
        return (int) (Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

}
