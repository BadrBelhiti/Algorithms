package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> sorted = new PriorityQueue<>(this::compare);

        sorted.addAll(Arrays.asList(points));

        int[][] res = new int[K][];

        for (int i = 0; i < res.length; i++){
            res[i] = sorted.poll();
        }

        return res;
    }

    public int compare(int[] a, int[] b){
        return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
    }

}
