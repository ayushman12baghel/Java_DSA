import java.util.*;

public class Special_Array_With_X_Elements_Greater_Than_or_Equal_X {

    // Approach 1 Brute Force O(n^2)
    public static int specialArray(int[] nums) {
        int ans = -1;
        for (int i = 0; i <= nums.length; i++) {
            int k = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    k++;
                }
            }

            if (k == i) {
                ans = i;
            }
        }

        return ans;
    }

    // Approach 2 Using Binary Search and Sorting O(nlogn)
    public static int specialArray2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i <= n; i++) {
            int k = binaryGreaterOrEqual(nums, i);

            if (n - k == i) {
                return i;
            }
        }

        return -1;
    }

    public static int binaryGreaterOrEqual(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    // Approaxh 3 Binary Search on Ans + Sorting
    public static int specialArray3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int index = binaryGreaterOrEqual(nums, mid);
            int count = n - index;

            if (count == mid) {
                return mid;
            } else if (count > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 4, 3, 0, 4 };
    }
}
