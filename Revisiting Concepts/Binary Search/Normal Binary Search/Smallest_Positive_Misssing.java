import java.util.*;

public class Smallest_Positive_Misssing {

    // Approach 1 Using Sorting O(n log n)
    public static int missingNumber(int nums[]) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > 0) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (index == -1) {
            return 1;
        }

        int expected = 1;

        for (int i = index; i < nums.length; i++) {
            if (expected == nums[i]) {
                while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                    i++;
                }
                expected++;
            } else if (nums[i] > expected) {
                return expected;
            }
        }

        return expected;
    }

    // Approach 2 Cycle Sort O(n)
    public static int missingNumber2(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        int nums[] = { 2, -3, 4, 1, 1, 7 };

        System.out.println(missingNumber(nums));
        System.out.println(missingNumber2(nums));
    }
}
