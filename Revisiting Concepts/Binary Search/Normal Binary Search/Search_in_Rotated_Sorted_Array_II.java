import java.util.*;

public class Search_in_Rotated_Sorted_Array_II {

    // Approach Using Binary Search O(logn)
    public static boolean Search(int[] nums, int target) {
        int pivotIndex = findPivot(nums);

        return binarySearch(nums, 0, pivotIndex - 1, target) || binarySearch(nums, pivotIndex, nums.length - 1, target);
    }

    public static int findPivot(int nums[]) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[left] == nums[left + 1]) {
                left++;
            }

            while (right > left && nums[right] == nums[right - 1]) {
                right--;
            }

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static boolean binarySearch(int nums[], int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1 };
        int target = 2;

        System.out.println(Search(nums, target));
    }
}
