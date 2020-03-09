import testing.TestCaseBuilder;
import java.util.Arrays;

public class Sorting {

    public static void test(int cases, long seed){
        System.out.println("Sorting test cases");
        int[][][] tests = TestCaseBuilder.sortedArrays(cases, seed);
        int testsPassed = 0;
        for (int i = 0; i < cases; i++){
            boolean passed = Arrays.equals(tests[1][i], testsort(tests[0][i]));
            if (passed){
                testsPassed++;
            } else {
                System.out.printf("Expected: %s Output: %s%n", Arrays.toString(tests[1][i]), Arrays.toString(testsort(tests[0][i])));
            }
        }
        System.out.printf("Passed: %d/%d%n", testsPassed, cases);
    }

    private static int[] testsort(int[] arr){
        return mergesort(arr);
    }

    // TODO
    public static int[] quicksort(int[] arr){
        return arr;
    }

    /*
        Basically the brute force of sorting algorithms.
        Best case - O(n^2)
        Average case - O(n^2)
        Worst case - O(n^2)
     */

    public static int[] selectionsort(int[] arr){

        for (int i = 0; i < arr.length; i++){
            int min = arr[i];
            int index = i;
            for (int j = i; j < arr.length; j++){
                if (arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    /*
        Practical for smaller arrays.
        Best case - O(n)
        Average case - O(n^2)
        Worst case - O(n^2)
     */

    public static int[] insertionsort(int[] arr){

        for (int i = 1; i < arr.length; i++){
            int curr = arr[i];
            int index = i - 1;

            while (index >= 0 && arr[index] > curr){
                arr[index + 1] = arr[index];
                index--;
            }

            arr[index + 1] = curr;
        }

        return arr;
    }

    /*
        Fast sub-quadratic general-purpose algorithm.
        Best case - O(nlogn)
        Average case - O(nlogn)
        Worst case - O(nlogn)
     */

    public static int[] mergesort(int[] arr){

        // No further computation required for these trivial cases
        if (arr.length == 1 || arr.length == 0){
            return arr;
        }

        // Create two subarrays by bisecting arr
        int[] beginning = new int[arr.length / 2];
        int[] ending = new int[arr.length - beginning.length];

        System.arraycopy(arr, 0, beginning, 0, beginning.length);
        System.arraycopy(arr, beginning.length, ending, 0, ending.length);

        // Recursively sort subarrays
        beginning = mergesort(beginning);
        ending = mergesort(ending);


        // Merge the two subarrays
        int[] result = new int[arr.length];
        int first = 0;
        int end = 0;

        while (first + end < result.length){

            if (first >= beginning.length){
                result[first + end] = ending[end];
                end++;
                continue;
            } else if (end >= ending.length){
                result[first + end] = beginning[first];
                first++;
                continue;
            }

            if (beginning[first] < ending[end]){
                result[first + end] = beginning[first];
                first++;
            } else {
                result[first + end] = ending[end];
                end++;
            }
        }

        return result;
    }

}
