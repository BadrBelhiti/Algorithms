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


    private static int partition(int[] arr, int low, int high){

        int pivot = (int) (Math.random() * (high - low + 1) + low);
        int pivotValue = arr[pivot];

        swap(arr, pivot, high);

        int smallestElementTail = low;

        for (int i = low; i < high; i++){
            if (arr[i] < pivotValue){
                swap(arr, i, smallestElementTail);
                smallestElementTail++;
            }
        }

        swap(arr, high, smallestElementTail);

        return smallestElementTail;
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
