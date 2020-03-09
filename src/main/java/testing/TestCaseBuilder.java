package testing;

import java.util.Arrays;
import java.util.Random;

public class TestCaseBuilder {

    /*
        returns 3D matrix [input/output][case][element]
        First index is either 0 or 1. 0 for input, 1 for expected output.
        Second index specifies individual case to be tested.
        Third index specifies individual element in current test case.
     */

    public static int[][][] sortedArrays(int cases, long seed){
        int[][][] result = new int[2][cases][];
        Random random = new Random(seed);

        for (int i = 0; i < cases; i++){
            int size = random.nextInt(10) + 1;
            int[] arr = new int[size];
            for (int j = 0; j < size; j++){
                arr[j] = random.nextInt(200) - 100;
            }
            result[0][i] = arr.clone();
            Arrays.sort(arr);
            result[1][i] = arr.clone();
        }
        return result;
    }

}
