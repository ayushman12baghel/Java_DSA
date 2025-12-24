import java.util.*;

//Approach Binary Search O(logn)
class Solution {
    public int countLessEqual(int[] arr, int x) {
        int n = arr.length;
        int pivot = findPivot(arr);

        int count = 0;
        count += countInSorted(arr, 0, pivot - 1, x);
        count += countInSorted(arr, pivot, n - 1, x);

        return count;
    }

    private int findPivot(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countInSorted(int[] arr, int low, int high, int x) {
        int start = low;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans == -1 ? 0 : ans - start + 1;
    }
}
