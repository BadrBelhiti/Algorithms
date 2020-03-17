package datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Graph<T> {

    private HashMap<Node<T>, Integer> nodeToIndex;
    private HashMap<Integer, Node<T>> indexToNode;
    private int[][] weights;

    public Graph(int size){
        this.nodeToIndex = new HashMap<>();
        this.indexToNode = new HashMap<>();
        this.weights = new int[size][size];

        for (int i = 0; i < size; i++){
            Arrays.fill(weights[i], Integer.MAX_VALUE);
        }
    }

    public void addEdge(Node<T> source, Node<T> dest, int weight){
        if (!nodeToIndex.containsKey(source)){
            addVertex(source);
        }

        if (!nodeToIndex.containsKey(dest)){
            addVertex(dest);
        }

        int sourceIndex = nodeToIndex.get(source);
        int destIndex = nodeToIndex.get(dest);

        weights[sourceIndex][destIndex] = weight;
    }

    public void addVertex(Node<T> node){
        int index = nodeToIndex.size();
        nodeToIndex.put(node, index);
        indexToNode.put(index, node);
    }

    public List<Node<T>> getAdjacent(Node<T> source){
        List<Node<T>> adjacent = new ArrayList<>();
        int sourceIndex = nodeToIndex.get(source);
        for (int i = 0; i < weights[sourceIndex].length; i++){
            if (weights[sourceIndex][i] != Integer.MAX_VALUE){
                adjacent.add(indexToNode.get(i));
            }
        }
        return adjacent;
    }

    public int getWeight(Node<T> source, Node<T> dest){
        return weights[nodeToIndex.get(source)][nodeToIndex.get(dest)];
    }

}
