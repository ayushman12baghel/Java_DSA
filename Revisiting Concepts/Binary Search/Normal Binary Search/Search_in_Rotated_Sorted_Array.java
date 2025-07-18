import java.util.*;

public class Search_in_Rotated_Sorted_Array {

    // Binary Search O(log n)
    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int upToPivot = binarySearch(nums, 0, pivot - 1, target);
        if (upToPivot != -1) {
            return upToPivot;
        }
        int afterPivot = binarySearch(nums, pivot, nums.length - 1, target);

        return afterPivot;
    }

    public static int findPivot(int nums[]) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static int binarySearch(int nums[], int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;

        System.out.println(search(nums, target));
    }
}
