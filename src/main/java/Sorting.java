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
        return quicksort(arr, 0, arr.length - 1);
    }

    /*
        Advantageous over mergesort in sorting data structures that allow random access (e.g. arrays).
        Also takes less space than mergesort. Not preferred when sorting data that is very similar or contains a lot of duplicates.
        Such a case results in more suboptimal pivots being chosen, moving the time complexity towards O(n^2).

        Best case - O(nlogn)
        Average case - O(nlogn)
        Worst case - O(n^2)

     */

    public static int[] quicksort(int[] arr, int start, int end){

        if (start < end){

            int pivot = partition(arr, start, end);

            quicksort(arr, start, pivot - 1);
            quicksort(arr, pivot + 1, end);
        }

        return arr;
    }

    private static int partition(int[] arr, int start, int end){

        // Select random pivot
        int pivot = (int) (Math.random() * (end - start + 1) + start);
        int pivotValue = arr[pivot];

        // Move pivot to end of array for safekeeping
        swap(arr, pivot, end);

        int smallElementsTail = start;

        // Loop through subarray, moving values smaller than 'pivotValue' to have indices smaller than 'smallElementsTrail'.
        // This guarantees that all values smaller than the pivot will be left of the pivot, and all values greater than or equal to
        // the pivot will be right of the pivot.
        for (int i = start; i < end; i++){
            if (arr[i] < pivotValue){
                swap(arr, i, smallElementsTail);
                smallElementsTail++;
            }
        }

        // Move pivot back. Pivot is now in its final and correct position in the sorted array.
        // Remember that the pivot is now sitting in index 'end' from the first swap.
        swap(arr, end, smallElementsTail);

        // Return index of where the pivot now lies. We can then create subarrays around this index to also sort.
        return smallElementsTail;
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
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
        Practical for smaller datasets.
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
        Advantageous over quicksort in sorting datasets where swaps are expensive and random access isn't allowed (e.g. linked lists).

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
