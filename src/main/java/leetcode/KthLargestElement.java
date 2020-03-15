package leetcode;

public class KthLargestElement {

    /*

    This problem can be solved in O(n) time and O(1) space using the quickselect algorithm.

     */

    public static int kthLargestElement(int[] arr, int k){

        int low = 0;
        int high = arr.length - 1;
        int pivot;

        while (low <= high){

            pivot = partition(arr, low, high);

            if (pivot == arr.length - k){
                return arr[pivot];
            }

            if (pivot < arr.length - k){
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }

        return -1;
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

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
