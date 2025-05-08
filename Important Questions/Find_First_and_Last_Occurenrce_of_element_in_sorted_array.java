import java.util.*;

public class Find_First_and_Last_Occurenrce_of_element_in_sorted_array {

    public static int[] searchRange(int nums[], int target) {
        int first = searchFirst(nums, target);
        int second = searchLast(nums, target);

        return new int[] { first, second };
    }

    public static int searchFirst(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static int searchLast(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        int ans[] = searchRange(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
