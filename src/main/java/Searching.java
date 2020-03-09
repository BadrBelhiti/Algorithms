public class Searching {

    public static void test(int cases, long seed){
        int[] arr = {-5, -4, -3, -2, 1, 5, 7};
        System.out.println(binarySearch(arr, -3, 0, arr.length - 1));
    }

    /*
        Fastest way to search for element in sorted array.
        Best case - O(logn)
        Average case - O(logn)
        Worst case - O(logn)
     */

    public static int binarySearch(int[] arr, int target, int low, int high){

        // Interval has inverted with no find. Therefore target is not in arr.
        if (low > high){
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target){
            // Found element at index
            return mid;
        } else if (arr[mid] > target){
            // Middle element is greater than target. Search left subarray.
            return binarySearch(arr, target, low, mid - 1);
        } else {
            // Middle element if less than target. Search right subarray.
            return binarySearch(arr, target, mid + 1, high);
        }
    }

}
