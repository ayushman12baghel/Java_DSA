import java.util.*;

public class First_and_Last_Poition_of_Element_in_Sorted_Array {

    // Approach Using Binary Search
    public static int[] searchRange(int[] nums, int target) {
        int firstIndex = binarySearch(nums, target);
        int lastIndex = binarySearch2(nums, target);

        return new int[] { firstIndex, lastIndex };
    }

    public static int binarySearch(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static int binarySearch2(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        int ans[] = searchRange(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
