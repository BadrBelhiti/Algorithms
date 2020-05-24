package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

    public IntervalListIntersections(){
        int[][] a = new int[][]{new int[]{0,2}, new int[]{5,10}, new int[]{13,23}, new int[]{24,25}};
        int[][] b = new int[][]{new int[]{1,5}, new int[]{8,12}, new int[]{15,24}, new int[]{25,26}};

        // Expected: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        System.out.println(Arrays.deepToString(intervalIntersection(a, b)));
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        if (A.length == 0 || B.length == 0){
            return new int[][]{};
        }

        int aPointer = 0;
        int bPointer = 0;

        List<int[]> list = new ArrayList<>();

        do {
            int[] aCurr = A[Math.min(aPointer, A.length - 1)];
            int[] bCurr = B[Math.min(bPointer, B.length - 1)];
            if (overlaps(aCurr, bCurr)) {
                list.add(findOverlap(aCurr, bCurr));
            }

            if (aCurr[1] < bCurr[1]) {
                aPointer++;
            } else {
                bPointer++;
            }

        } while (aPointer < A.length && bPointer < B.length);

        return list.toArray(new int[list.size()][]);
    }

    public boolean overlaps(int[] a, int[] b){
        return !(a[1] < b[0] || a[0] > b[1]);
    }

    public int[] findOverlap(int[] a, int[] b){
        return new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
    }

}
